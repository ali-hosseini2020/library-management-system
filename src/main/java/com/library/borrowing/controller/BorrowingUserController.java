package com.library.borrowing.controller;
import com.library.borrowing.dto.BorrowingUserDTO;
import com.library.borrowing.service.BorrowingUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/borrowing-users")
public class BorrowingUserController {

    @Autowired
    private BorrowingUserService borrowingUserService;

    @GetMapping
    public List<BorrowingUserDTO> getAllBorrowingUsers() {
        return borrowingUserService.getAllBorrowingUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingUserDTO> getBorrowingUserById(@PathVariable Long id) {
        try {
            BorrowingUserDTO borrowingUserDTO = borrowingUserService.getBorrowingUserById(id);
            return ResponseEntity.ok(borrowingUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingUserDTO> saveBorrowingUser(@RequestBody BorrowingUserDTO borrowingUserDTO) {
        BorrowingUserDTO savedBorrowingUserDTO = borrowingUserService.saveBorrowingUser(borrowingUserDTO);
        return ResponseEntity.status(201).body(savedBorrowingUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowingUser(@PathVariable Long id) {
        try {
            borrowingUserService.deleteBorrowingUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<BorrowingUserDTO> findBorrowingUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return borrowingUserService.findBorrowingUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<BorrowingUserDTO> findBorrowingUsersByEmail(@RequestParam String email) {
        return borrowingUserService.findBorrowingUsersByEmail(email);
    }
}
