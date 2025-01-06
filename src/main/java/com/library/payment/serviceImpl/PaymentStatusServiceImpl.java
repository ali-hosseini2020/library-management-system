package com.library.payment.serviceImpl;

import com.library.payment.PaymentStatus;
import com.library.payment.dto.PaymentStatusDTO;
import com.library.payment.mapper.PaymentStatusMapper;
import com.library.payment.repository.PaymentStatusRepository;
import com.library.payment.service.PaymentStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentStatusServiceImpl implements PaymentStatusService {

    @Autowired
    private PaymentStatusRepository paymentStatusRepository;

    @Autowired
    private PaymentStatusMapper paymentStatusMapper;

    @Override
    public List<PaymentStatusDTO> getAllPaymentStatuses() {
        List<PaymentStatus> paymentStatuses = paymentStatusRepository.findAll();
        return paymentStatuses.stream()
                .map(paymentStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentStatusDTO getPaymentStatusById(Long id) {
        PaymentStatus paymentStatus = paymentStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment status not found with id " + id));
        return paymentStatusMapper.toDTO(paymentStatus);
    }

    @Override
    public PaymentStatusDTO savePaymentStatus(PaymentStatusDTO paymentStatusDTO) {
        PaymentStatus paymentStatus = paymentStatusMapper.toEntity(paymentStatusDTO);
        PaymentStatus savedPaymentStatus = paymentStatusRepository.save(paymentStatus);
        return paymentStatusMapper.toDTO(savedPaymentStatus);
    }

    @Override
    public void deletePaymentStatus(Long id) {
        if (!paymentStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment status not found with id " + id);
        }
        paymentStatusRepository.deleteById(id);
    }

    @Override
    public List<PaymentStatusDTO> findPaymentStatusesByPaymentId(Long paymentId) {
        List<PaymentStatus> paymentStatuses = paymentStatusRepository.findByPaymentId(paymentId);
        return paymentStatuses.stream()
                .map(paymentStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
