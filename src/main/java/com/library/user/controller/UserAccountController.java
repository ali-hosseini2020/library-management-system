package com.library.user.controller;
import com.library.user.dto.UserAccountDTO;
import com.library.user.service.UserAccountService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-accounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @GetMapping
    public List<UserAccountDTO> getAllUserAccounts() {
        return userAccountService.getAllUserAccounts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAccountDTO> getUserAccountById(@PathVariable Long id) {
        try {
            UserAccountDTO userAccountDTO = userAccountService.getUserAccountById(id);
            return ResponseEntity.ok(userAccountDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserAccountDTO> saveUserAccount(@RequestBody UserAccountDTO userAccountDTO) {
        UserAccountDTO savedUserAccountDTO = userAccountService.saveUserAccount(userAccountDTO);
        return ResponseEntity.status(201).body(savedUserAccountDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserAccount(@PathVariable Long id) {
        try {
            userAccountService.deleteUserAccount(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/username")
    public List<UserAccountDTO> findUserAccountsByUsername(@RequestParam String username) {
        return userAccountService.findUserAccountsByUsername(username);
    }

    @GetMapping("/search/user/{userId}")
    public List<UserAccountDTO> findUserAccountsByUserId(@PathVariable Long userId) {
        return userAccountService.findUserAccountsByUserId(userId);
    }
}
