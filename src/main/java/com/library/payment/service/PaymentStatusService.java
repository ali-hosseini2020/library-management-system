package com.library.payment.service;

import com.library.payment.dto.PaymentStatusDTO;

import java.util.List;

public interface PaymentStatusService {
    List<PaymentStatusDTO> getAllPaymentStatuses();
    PaymentStatusDTO getPaymentStatusById(Long id);
    PaymentStatusDTO savePaymentStatus(PaymentStatusDTO paymentStatusDTO);
    void deletePaymentStatus(Long id);
    List<PaymentStatusDTO> findPaymentStatusesByPaymentId(Long paymentId);
}
