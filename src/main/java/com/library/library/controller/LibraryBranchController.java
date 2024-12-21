package com.library.library.controller;
import com.library.library.dto.LibraryBranchDTO;
import com.library.library.service.LibraryBranchService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/library-branches")
public class LibraryBranchController {

    @Autowired
    private LibraryBranchService libraryBranchService;

    @GetMapping
    public List<LibraryBranchDTO> getAllLibraryBranches() {
        return libraryBranchService.getAllLibraryBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBranchDTO> getLibraryBranchById(@PathVariable Long id) {
        try {
            LibraryBranchDTO libraryBranchDTO = libraryBranchService.getLibraryBranchById(id);
            return ResponseEntity.ok(libraryBranchDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<LibraryBranchDTO> saveLibraryBranch(@RequestBody LibraryBranchDTO libraryBranchDTO) {
        LibraryBranchDTO savedLibraryBranchDTO = libraryBranchService.saveLibraryBranch(libraryBranchDTO);
        return ResponseEntity.status(201).body(savedLibraryBranchDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryBranch(@PathVariable Long id) {
        try {
            libraryBranchService.deleteLibraryBranch(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<LibraryBranchDTO> findLibraryBranchesByName(@RequestParam String name) {
        return libraryBranchService.findLibraryBranchesByName(name);
    }

    @GetMapping("/search/address")
    public List<LibraryBranchDTO> findLibraryBranchesByAddress(@RequestParam String address) {
        return libraryBranchService.findLibraryBranchesByAddress(address);
    }

    @GetMapping("/search/library/{libraryId}")
    public List<LibraryBranchDTO> findLibraryBranchesByLibraryId(@PathVariable Long libraryId) {
        return libraryBranchService.findLibraryBranchesByLibraryId(libraryId);
    }
}
