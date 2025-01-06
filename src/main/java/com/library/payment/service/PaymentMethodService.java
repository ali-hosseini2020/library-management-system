package com.library.payment.service;

import com.library.payment.dto.PaymentMethodDTO;

import java.util.List;

public interface PaymentMethodService {
    List<PaymentMethodDTO> getAllPaymentMethods();
    PaymentMethodDTO getPaymentMethodById(Long id);
    PaymentMethodDTO savePaymentMethod(PaymentMethodDTO paymentMethodDTO);
    void deletePaymentMethod(Long id);
    List<PaymentMethodDTO> findPaymentMethodsByUserId(Long userId);
}
