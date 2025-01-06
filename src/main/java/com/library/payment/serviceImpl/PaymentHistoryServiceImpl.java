package com.library.payment.serviceImpl;

import com.library.payment.PaymentHistory;
import com.library.payment.dto.PaymentHistoryDTO;
import com.library.payment.mapper.PaymentHistoryMapper;
import com.library.payment.repository.PaymentHistoryRepository;
import com.library.payment.service.PaymentHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentHistoryServiceImpl implements PaymentHistoryService {

    @Autowired
    private PaymentHistoryRepository paymentHistoryRepository;

    @Autowired
    private PaymentHistoryMapper paymentHistoryMapper;

    @Override
    public List<PaymentHistoryDTO> getAllPaymentHistories() {
        List<PaymentHistory> paymentHistories = paymentHistoryRepository.findAll();
        return paymentHistories.stream()
                .map(paymentHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentHistoryDTO getPaymentHistoryById(Long id) {
        PaymentHistory paymentHistory = paymentHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment history not found with id " + id));
        return paymentHistoryMapper.toDTO(paymentHistory);
    }

    @Override
    public PaymentHistoryDTO savePaymentHistory(PaymentHistoryDTO paymentHistoryDTO) {
        PaymentHistory paymentHistory = paymentHistoryMapper.toEntity(paymentHistoryDTO);
        PaymentHistory savedPaymentHistory = paymentHistoryRepository.save(paymentHistory);
        return paymentHistoryMapper.toDTO(savedPaymentHistory);
    }

    @Override
    public void deletePaymentHistory(Long id) {
        if (!paymentHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment history not found with id " + id);
        }
        paymentHistoryRepository.deleteById(id);
    }

    @Override
    public List<PaymentHistoryDTO> findPaymentHistoriesByPaymentId(Long paymentId) {
        List<PaymentHistory> paymentHistories = paymentHistoryRepository.findByPaymentId(paymentId);
        return paymentHistories.stream()
                .map(paymentHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
