package com.library.payment.service;

import com.library.payment.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    List<PaymentDTO> getAllPayments();
    PaymentDTO getPaymentById(Long id);
    PaymentDTO savePayment(PaymentDTO paymentDTO);
    void deletePayment(Long id);
    List<PaymentDTO> findPaymentsByUserId(Long userId);
    List<PaymentDTO> findPaymentsByStatus(String status);
}
