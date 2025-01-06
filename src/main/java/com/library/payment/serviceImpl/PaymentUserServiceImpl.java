package com.library.payment.serviceImpl;

import com.library.payment.PaymentUser;
import com.library.payment.dto.PaymentUserDTO;
import com.library.payment.mapper.PaymentUserMapper;
import com.library.payment.repository.PaymentUserRepository;
import com.library.payment.service.PaymentUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentUserServiceImpl implements PaymentUserService {

    @Autowired
    private PaymentUserRepository paymentUserRepository;

    @Autowired
    private PaymentUserMapper paymentUserMapper;

    @Override
    public List<PaymentUserDTO> getAllPaymentUsers() {
        List<PaymentUser> paymentUsers = paymentUserRepository.findAll();
        return paymentUsers.stream()
                .map(paymentUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PaymentUserDTO getPaymentUserById(Long id) {
        PaymentUser paymentUser = paymentUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment user not found with id " + id));
        return paymentUserMapper.toDTO(paymentUser);
    }

    @Override
    public PaymentUserDTO savePaymentUser(PaymentUserDTO paymentUserDTO) {
        PaymentUser paymentUser = paymentUserMapper.toEntity(paymentUserDTO);
        PaymentUser savedPaymentUser = paymentUserRepository.save(paymentUser);
        return paymentUserMapper.toDTO(savedPaymentUser);
    }

    @Override
    public void deletePaymentUser(Long id) {
        if (!paymentUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Payment user not found with id " + id);
        }
        paymentUserRepository.deleteById(id);
    }

    @Override
    public List<PaymentUserDTO> findPaymentUsersByName(String firstName, String lastName) {
        List<PaymentUser> paymentUsers = paymentUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return paymentUsers.stream()
                .map(paymentUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<PaymentUserDTO> findPaymentUsersByEmail(String email) {
        List<PaymentUser> paymentUsers = paymentUserRepository.findByEmailContaining(email);
        return paymentUsers.stream()
                .map(paymentUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
