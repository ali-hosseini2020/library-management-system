package com.library.fine.controller;

import com.library.fine.dto.FineDTO;
import com.library.fine.service.FineService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fines")
public class FineController {

    @Autowired
    private FineService fineService;

    @GetMapping
    public List<FineDTO> getAllFines() {
        return fineService.getAllFines();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FineDTO> getFineById(@PathVariable Long id) {
        try {
            FineDTO fineDTO = fineService.getFineById(id);
            return ResponseEntity.ok(fineDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<FineDTO> saveFine(@RequestBody FineDTO fineDTO) {
        FineDTO savedFineDTO = fineService.saveFine(fineDTO);
        return ResponseEntity.status(201).body(savedFineDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFine(@PathVariable Long id) {
        try {
            fineService.deleteFine(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<FineDTO> findFinesByUserId(@PathVariable Long userId) {
        return fineService.findFinesByUserId(userId);
    }

    @GetMapping("/search/status")
    public List<FineDTO> findFinesByStatus(@RequestParam String status) {
        return fineService.findFinesByStatus(status);
    }
}
