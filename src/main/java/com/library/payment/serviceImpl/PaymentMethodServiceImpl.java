package com.library.payment.serviceImpl;

import com.library.payment.PaymentMethod;
import com.library.payment.dto.PaymentMethodDTO;
import com.library.payment.mapper.PaymentMethodMapper;
import com.library.payment.repository.PaymentMethodRepository;
import com.library.payment.service.PaymentMethodService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentMethodServiceImpl implements PaymentMethodService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodMapper paymentMethodMapper;

    @Override
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findAll();
        return paymentMethods.stream()
                .map(paymentMethodMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentMethodDTO getPaymentMethodById(Long id) {
        PaymentMethod paymentMethod = paymentMethodRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment method not found with id " + id));
        return paymentMethodMapper.toDTO(paymentMethod);
    }

    @Override
    public PaymentMethodDTO savePaymentMethod(PaymentMethodDTO paymentMethodDTO) {
        PaymentMethod paymentMethod = paymentMethodMapper.toEntity(paymentMethodDTO);
        PaymentMethod savedPaymentMethod = paymentMethodRepository.save(paymentMethod);
        return paymentMethodMapper.toDTO(savedPaymentMethod);
    }

    @Override
    public void deletePaymentMethod(Long id) {
        if (!paymentMethodRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment method not found with id " + id);
        }
        paymentMethodRepository.deleteById(id);
    }

    @Override
    public List<PaymentMethodDTO> findPaymentMethodsByUserId(Long userId) {
        List<PaymentMethod> paymentMethods = paymentMethodRepository.findByUserId(userId);
        return paymentMethods.stream()
                .map(paymentMethodMapper::toDTO)
                .collect(Collectors.toList());
    }
}
