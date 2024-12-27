package com.library.borrowing.controller;
import com.library.borrowing.dto.BorrowingItemDTO;
import com.library.borrowing.service.BorrowingItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/borrowing-items")
public class BorrowingItemController {

    @Autowired
    private BorrowingItemService borrowingItemService;

    @GetMapping
    public List<BorrowingItemDTO> getAllBorrowingItems() {
        return borrowingItemService.getAllBorrowingItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingItemDTO> getBorrowingItemById(@PathVariable Long id) {
        try {
            BorrowingItemDTO borrowingItemDTO = borrowingItemService.getBorrowingItemById(id);
            return ResponseEntity.ok(borrowingItemDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingItemDTO> saveBorrowingItem(@RequestBody BorrowingItemDTO borrowingItemDTO) {
        BorrowingItemDTO savedBorrowingItemDTO = borrowingItemService.saveBorrowingItem(borrowingItemDTO);
        return ResponseEntity.status(201).body(savedBorrowingItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowingItem(@PathVariable Long id) {
        try {
            borrowingItemService.deleteBorrowingItem(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/borrowing/{borrowingId}")
    public List<BorrowingItemDTO> findBorrowingItemsByBorrowingId(@PathVariable Long borrowingId) {
        return borrowingItemService.findBorrowingItemsByBorrowingId(borrowingId);
    }
}
