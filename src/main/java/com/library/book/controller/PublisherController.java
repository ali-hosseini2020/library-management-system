package com.library.book.controller;

import com.library.book.dto.PublisherDTO;
import com.library.book.service.PublisherService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @GetMapping
    public List<PublisherDTO> getAllPublishers() {
        return publisherService.getAllPublishers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherDTO> getPublisherById(@PathVariable Long id) {
        try {
            PublisherDTO publisherDTO = publisherService.getPublisherById(id);
            return ResponseEntity.ok(publisherDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<PublisherDTO> savePublisher(@RequestBody PublisherDTO publisherDTO) {
        PublisherDTO savedPublisherDTO = publisherService.savePublisher(publisherDTO);
        return ResponseEntity.status(201).body(savedPublisherDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        try {
            publisherService.deletePublisher(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<PublisherDTO> findPublishersByName(@RequestParam String name) {
        return publisherService.findPublishersByName(name);
    }
}
