package com.library.payment.controller;
import com.library.payment.dto.PaymentStatusDTO;
import com.library.payment.service.PaymentStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/payment-statuses")
public class PaymentStatusController {

    @Autowired
    private PaymentStatusService paymentStatusService;

    @GetMapping
    public List<PaymentStatusDTO> getAllPaymentStatuses() {
        return paymentStatusService.getAllPaymentStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentStatusDTO> getPaymentStatusById(@PathVariable Long id) {
        try {
            PaymentStatusDTO paymentStatusDTO = paymentStatusService.getPaymentStatusById(id);
            return ResponseEntity.ok(paymentStatusDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PaymentStatusDTO> savePaymentStatus(@RequestBody PaymentStatusDTO paymentStatusDTO) {
        PaymentStatusDTO savedPaymentStatusDTO = paymentStatusService.savePaymentStatus(paymentStatusDTO);
        return ResponseEntity.status(201).body(savedPaymentStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePaymentStatus(@PathVariable Long id) {
        try {
            paymentStatusService.deletePaymentStatus(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/payment/{paymentId}")
    public List<PaymentStatusDTO> findPaymentStatusesByPaymentId(@PathVariable Long paymentId) {
        return paymentStatusService.findPaymentStatusesByPaymentId(paymentId);
    }
}
