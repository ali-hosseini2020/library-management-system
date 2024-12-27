package com.library.borrowing.controller;
import com.library.borrowing.dto.BorrowingStatusDTO;
import com.library.borrowing.service.BorrowingStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/borrowing-statuses")
public class BorrowingStatusController {

    @Autowired
    private BorrowingStatusService borrowingStatusService;

    @GetMapping
    public List<BorrowingStatusDTO> getAllBorrowingStatuses() {
        return borrowingStatusService.getAllBorrowingStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingStatusDTO> getBorrowingStatusById(@PathVariable Long id) {
        try {
            BorrowingStatusDTO borrowingStatusDTO = borrowingStatusService.getBorrowingStatusById(id);
            return ResponseEntity.ok(borrowingStatusDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingStatusDTO> saveBorrowingStatus(@RequestBody BorrowingStatusDTO borrowingStatusDTO) {
        BorrowingStatusDTO savedBorrowingStatusDTO = borrowingStatusService.saveBorrowingStatus(borrowingStatusDTO);
        return ResponseEntity.status(201).body(savedBorrowingStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowingStatus(@PathVariable Long id) {
        try {
            borrowingStatusService.deleteBorrowingStatus(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/borrowing/{borrowingId}")
    public List<BorrowingStatusDTO> findBorrowingStatusesByBorrowingId(@PathVariable Long borrowingId) {
        return borrowingStatusService.findBorrowingStatusesByBorrowingId(borrowingId);
    }
}
