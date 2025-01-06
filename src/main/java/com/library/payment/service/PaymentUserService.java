package com.library.payment.service;

import com.library.payment.dto.PaymentUserDTO;

import java.util.List;

public interface PaymentUserService {
    List<PaymentUserDTO> getAllPaymentUsers();
    PaymentUserDTO getPaymentUserById(Long id);
    PaymentUserDTO savePaymentUser(PaymentUserDTO paymentUserDTO);
    void deletePaymentUser(Long id);
    List<PaymentUserDTO> findPaymentUsersByName(String firstName, String lastName);
    List<PaymentUserDTO> findPaymentUsersByEmail(String email);
}
