package com.library.borrowing.controller;
import com.library.borrowing.dto.BorrowingDTO;
import com.library.borrowing.service.BorrowingService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/borrowings")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping
    public List<BorrowingDTO> getAllBorrowings() {
        return borrowingService.getAllBorrowings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingDTO> getBorrowingById(@PathVariable Long id) {
        try {
            BorrowingDTO borrowingDTO = borrowingService.getBorrowingById(id);
            return ResponseEntity.ok(borrowingDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingDTO> saveBorrowing(@RequestBody BorrowingDTO borrowingDTO) {
        BorrowingDTO savedBorrowingDTO = borrowingService.saveBorrowing(borrowingDTO);
        return ResponseEntity.status(201).body(savedBorrowingDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowing(@PathVariable Long id) {
        try {
            borrowingService.deleteBorrowing(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<BorrowingDTO> findBorrowingsByUserId(@PathVariable Long userId) {
        return borrowingService.findBorrowingsByUserId(userId);
    }

    @GetMapping("/search/status")
    public List<BorrowingDTO> findBorrowingsByStatus(@RequestParam String status) {
        return borrowingService.findBorrowingsByStatus(status);
    }
}
