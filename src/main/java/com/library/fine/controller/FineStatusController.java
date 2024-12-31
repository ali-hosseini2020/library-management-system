package com.library.fine.controller;

import com.library.fine.dto.FineStatusDTO;
import com.library.fine.service.FineStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine-statuses")
public class FineStatusController {

    @Autowired
    private FineStatusService fineStatusService;

    @GetMapping
    public List<FineStatusDTO> getAllFineStatuses() {
        return fineStatusService.getAllFineStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FineStatusDTO> getFineStatusById(@PathVariable Long id) {
        try {
            FineStatusDTO fineStatusDTO = fineStatusService.getFineStatusById(id);
            return ResponseEntity.ok(fineStatusDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<FineStatusDTO> saveFineStatus(@RequestBody FineStatusDTO fineStatusDTO) {
        FineStatusDTO savedFineStatusDTO = fineStatusService.saveFineStatus(fineStatusDTO);
        return ResponseEntity.status(201).body(savedFineStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFineStatus(@PathVariable Long id) {
        try {
            fineStatusService.deleteFineStatus(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/fine/{fineId}")
    public List<FineStatusDTO> findFineStatusesByFineId(@PathVariable Long fineId) {
        return fineStatusService.findFineStatusesByFineId(fineId);
    }
}
