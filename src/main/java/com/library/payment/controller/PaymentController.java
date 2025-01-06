package com.library.payment.controller;
import com.library.payment.dto.PaymentDTO;
import com.library.payment.service.PaymentService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public List<PaymentDTO> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> getPaymentById(@PathVariable Long id) {
        try {
            PaymentDTO paymentDTO = paymentService.getPaymentById(id);
            return ResponseEntity.ok(paymentDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> savePayment(@RequestBody PaymentDTO paymentDTO) {
        PaymentDTO savedPaymentDTO = paymentService.savePayment(paymentDTO);
        return ResponseEntity.status(201).body(savedPaymentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        try {
            paymentService.deletePayment(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<PaymentDTO> findPaymentsByUserId(@PathVariable Long userId) {
        return paymentService.findPaymentsByUserId(userId);
    }

    @GetMapping("/search/status")
    public List<PaymentDTO> findPaymentsByStatus(@RequestParam String status) {
        return paymentService.findPaymentsByStatus(status);
    }
}
