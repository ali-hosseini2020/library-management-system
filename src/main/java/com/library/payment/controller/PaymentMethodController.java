package com.library.payment.controller;
import com.library.payment.dto.PaymentMethodDTO;
import com.library.payment.service.PaymentMethodService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment-methods")
public class PaymentMethodController {

    @Autowired
    private PaymentMethodService paymentMethodService;

    @GetMapping
    public List<PaymentMethodDTO> getAllPaymentMethods() {
        return paymentMethodService.getAllPaymentMethods();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentMethodDTO> getPaymentMethodById(@PathVariable Long id) {
        try {
            PaymentMethodDTO paymentMethodDTO = paymentMethodService.getPaymentMethodById(id);
            return ResponseEntity.ok(paymentMethodDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentMethodDTO> savePaymentMethod(@RequestBody PaymentMethodDTO paymentMethodDTO) {
        PaymentMethodDTO savedPaymentMethodDTO = paymentMethodService.savePaymentMethod(paymentMethodDTO);
        return ResponseEntity.status(201).body(savedPaymentMethodDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentMethod(@PathVariable Long id) {
        try {
            paymentMethodService.deletePaymentMethod(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<PaymentMethodDTO> findPaymentMethodsByUserId(@PathVariable Long userId) {
        return paymentMethodService.findPaymentMethodsByUserId(userId);
    }
}
