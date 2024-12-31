package com.library.fine.controller;

import com.library.fine.dto.FineHistoryDTO;
import com.library.fine.service.FineHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine-histories")
public class FineHistoryController {

    @Autowired
    private FineHistoryService fineHistoryService;

    @GetMapping
    public List<FineHistoryDTO> getAllFineHistories() {
        return fineHistoryService.getAllFineHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FineHistoryDTO> getFineHistoryById(@PathVariable Long id) {
        try {
            FineHistoryDTO fineHistoryDTO = fineHistoryService.getFineHistoryById(id);
            return ResponseEntity.ok(fineHistoryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<FineHistoryDTO> saveFineHistory(@RequestBody FineHistoryDTO fineHistoryDTO) {
        FineHistoryDTO savedFineHistoryDTO = fineHistoryService.saveFineHistory(fineHistoryDTO);
        return ResponseEntity.status(201).body(savedFineHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFineHistory(@PathVariable Long id) {
        try {
            fineHistoryService.deleteFineHistory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/fine/{fineId}")
    public List<FineHistoryDTO> findFineHistoriesByFineId(@PathVariable Long fineId) {
        return fineHistoryService.findFineHistoriesByFineId(fineId);
    }
}
