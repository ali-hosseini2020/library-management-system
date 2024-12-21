package com.library.library.controller;

import com.library.library.dto.LibraryDTO;
import com.library.library.service.LibraryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<LibraryDTO> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryDTO> getLibraryById(@PathVariable Long id) {
        try {
            LibraryDTO libraryDTO = libraryService.getLibraryById(id);
            return ResponseEntity.ok(libraryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<LibraryDTO> saveLibrary(@RequestBody LibraryDTO libraryDTO) {
        LibraryDTO savedLibraryDTO = libraryService.saveLibrary(libraryDTO);
        return ResponseEntity.status(201).body(savedLibraryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibrary(@PathVariable Long id) {
        try {
            libraryService.deleteLibrary(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<LibraryDTO> findLibrariesByName(@RequestParam String name) {
        return libraryService.findLibrariesByName(name);
    }

    @GetMapping("/search/address")
    public List<LibraryDTO> findLibrariesByAddress(@RequestParam String address) {
        return libraryService.findLibrariesByAddress(address);
    }
}
