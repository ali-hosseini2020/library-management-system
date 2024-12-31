package com.library.fine.controller;

import com.library.fine.dto.FineItemDTO;
import com.library.fine.service.FineItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fine-items")
public class FineItemController {

    @Autowired
    private FineItemService fineItemService;

    @GetMapping
    public List<FineItemDTO> getAllFineItems() {
        return fineItemService.getAllFineItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FineItemDTO> getFineItemById(@PathVariable Long id) {
        try {
            FineItemDTO fineItemDTO = fineItemService.getFineItemById(id);
            return ResponseEntity.ok(fineItemDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<FineItemDTO> saveFineItem(@RequestBody FineItemDTO fineItemDTO) {
        FineItemDTO savedFineItemDTO = fineItemService.saveFineItem(fineItemDTO);
        return ResponseEntity.status(201).body(savedFineItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFineItem(@PathVariable Long id) {
        try {
            fineItemService.deleteFineItem(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/fine/{fineId}")
    public List<FineItemDTO> findFineItemsByFineId(@PathVariable Long fineId) {
        return fineItemService.findFineItemsByFineId(fineId);
    }
}
