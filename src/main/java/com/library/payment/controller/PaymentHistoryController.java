package com.library.payment.controller;
import com.library.payment.dto.PaymentHistoryDTO;
import com.library.payment.service.PaymentHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment-histories")
public class PaymentHistoryController {

    @Autowired
    private PaymentHistoryService paymentHistoryService;

    @GetMapping
    public List<PaymentHistoryDTO> getAllPaymentHistories() {
        return paymentHistoryService.getAllPaymentHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentHistoryDTO> getPaymentHistoryById(@PathVariable Long id) {
        try {
            PaymentHistoryDTO paymentHistoryDTO = paymentHistoryService.getPaymentHistoryById(id);
            return ResponseEntity.ok(paymentHistoryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentHistoryDTO> savePaymentHistory(@RequestBody PaymentHistoryDTO paymentHistoryDTO) {
        PaymentHistoryDTO savedPaymentHistoryDTO = paymentHistoryService.savePaymentHistory(paymentHistoryDTO);
        return ResponseEntity.status(201).body(savedPaymentHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentHistory(@PathVariable Long id) {
        try {
            paymentHistoryService.deletePaymentHistory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/payment/{paymentId}")
    public List<PaymentHistoryDTO> findPaymentHistoriesByPaymentId(@PathVariable Long paymentId) {
        return paymentHistoryService.findPaymentHistoriesByPaymentId(paymentId);
    }
}
