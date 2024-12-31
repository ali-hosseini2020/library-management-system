package com.library.fine.controller;

import com.library.fine.dto.FineUserDTO;
import com.library.fine.service.FineUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine-users")
public class FineUserController {

    @Autowired
    private FineUserService fineUserService;

    @GetMapping
    public List<FineUserDTO> getAllFineUsers() {
        return fineUserService.getAllFineUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FineUserDTO> getFineUserById(@PathVariable Long id) {
        try {
            FineUserDTO fineUserDTO = fineUserService.getFineUserById(id);
            return ResponseEntity.ok(fineUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<FineUserDTO> saveFineUser(@RequestBody FineUserDTO fineUserDTO) {
        FineUserDTO savedFineUserDTO = fineUserService.saveFineUser(fineUserDTO);
        return ResponseEntity.status(201).body(savedFineUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFineUser(@PathVariable Long id) {
        try {
            fineUserService.deleteFineUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<FineUserDTO> findFineUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return fineUserService.findFineUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<FineUserDTO> findFineUsersByEmail(@RequestParam String email) {
        return fineUserService.findFineUsersByEmail(email);
    }
}
