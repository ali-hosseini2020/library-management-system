package com.library.borrowing.controller;
import com.library.borrowing.dto.BorrowingHistoryDTO;
import com.library.borrowing.service.BorrowingHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/borrowing-histories")
public class BorrowingHistoryController {

    @Autowired
    private BorrowingHistoryService borrowingHistoryService;

    @GetMapping
    public List<BorrowingHistoryDTO> getAllBorrowingHistories() {
        return borrowingHistoryService.getAllBorrowingHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingHistoryDTO> getBorrowingHistoryById(@PathVariable Long id) {
        try {
            BorrowingHistoryDTO borrowingHistoryDTO = borrowingHistoryService.getBorrowingHistoryById(id);
            return ResponseEntity.ok(borrowingHistoryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingHistoryDTO> saveBorrowingHistory(@RequestBody BorrowingHistoryDTO borrowingHistoryDTO) {
        BorrowingHistoryDTO savedBorrowingHistoryDTO = borrowingHistoryService.saveBorrowingHistory(borrowingHistoryDTO);
        return ResponseEntity.status(201).body(savedBorrowingHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowingHistory(@PathVariable Long id) {
        try {
            borrowingHistoryService.deleteBorrowingHistory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/borrowing/{borrowingId}")
    public List<BorrowingHistoryDTO> findBorrowingHistoriesByBorrowingId(@PathVariable Long borrowingId) {
        return borrowingHistoryService.findBorrowingHistoriesByBorrowingId(borrowingId);
    }
}
