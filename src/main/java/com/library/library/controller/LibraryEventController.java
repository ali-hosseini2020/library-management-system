package com.library.library.controller;
import com.library.library.dto.LibraryEventDTO;
import com.library.library.service.LibraryEventService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/library-events")
public class LibraryEventController {

    @Autowired
    private LibraryEventService libraryEventService;

    @GetMapping
    public List<LibraryEventDTO> getAllLibraryEvents() {
        return libraryEventService.getAllLibraryEvents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryEventDTO> getLibraryEventById(@PathVariable Long id) {
        try {
            LibraryEventDTO libraryEventDTO = libraryEventService.getLibraryEventById(id);
            return ResponseEntity.ok(libraryEventDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<LibraryEventDTO> saveLibraryEvent(@RequestBody LibraryEventDTO libraryEventDTO) {
        LibraryEventDTO savedLibraryEventDTO = libraryEventService.saveLibraryEvent(libraryEventDTO);
        return ResponseEntity.status(201).body(savedLibraryEventDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryEvent(@PathVariable Long id) {
        try {
            libraryEventService.deleteLibraryEvent(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<LibraryEventDTO> findLibraryEventsByName(@RequestParam String name) {
        return libraryEventService.findLibraryEventsByName(name);
    }

    @GetMapping("/search/library/{libraryId}")
    public List<LibraryEventDTO> findLibraryEventsByLibraryId(@PathVariable Long libraryId) {
        return libraryEventService.findLibraryEventsByLibraryId(libraryId);
    }

    @GetMapping("/search/branch/{branchId}")
    public List<LibraryEventDTO> findLibraryEventsByBranchId(@PathVariable Long branchId) {
        return libraryEventService.findLibraryEventsByBranchId(branchId);
    }
}
