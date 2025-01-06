package com.library.payment.service;

import com.library.payment.dto.PaymentHistoryDTO;

import java.util.List;

public interface PaymentHistoryService {
    List<PaymentHistoryDTO> getAllPaymentHistories();
    PaymentHistoryDTO getPaymentHistoryById(Long id);
    PaymentHistoryDTO savePaymentHistory(PaymentHistoryDTO paymentHistoryDTO);
    void deletePaymentHistory(Long id);
    List<PaymentHistoryDTO> findPaymentHistoriesByPaymentId(Long paymentId);
}
