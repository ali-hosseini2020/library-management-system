package com.library.payment.controller;
import com.library.payment.dto.PaymentUserDTO;
import com.library.payment.service.PaymentUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment-users")
public class PaymentUserController {

    @Autowired
    private PaymentUserService paymentUserService;

    @GetMapping
    public List<PaymentUserDTO> getAllPaymentUsers() {
        return paymentUserService.getAllPaymentUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentUserDTO> getPaymentUserById(@PathVariable Long id) {
        try {
            PaymentUserDTO paymentUserDTO = paymentUserService.getPaymentUserById(id);
            return ResponseEntity.ok(paymentUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentUserDTO> savePaymentUser(@RequestBody PaymentUserDTO paymentUserDTO) {
        PaymentUserDTO savedPaymentUserDTO = paymentUserService.savePaymentUser(paymentUserDTO);
        return ResponseEntity.status(201).body(savedPaymentUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentUser(@PathVariable Long id) {
        try {
            paymentUserService.deletePaymentUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<PaymentUserDTO> findPaymentUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return paymentUserService.findPaymentUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<PaymentUserDTO> findPaymentUsersByEmail(@RequestParam String email) {
        return paymentUserService.findPaymentUsersByEmail(email);
    }
}
