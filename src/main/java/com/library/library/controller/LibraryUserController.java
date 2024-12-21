package com.library.library.controller;
import com.library.library.dto.LibraryUserDTO;
import com.library.library.service.LibraryUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/library-users")
public class LibraryUserController {

    @Autowired
    private LibraryUserService libraryUserService;

    @GetMapping
    public List<LibraryUserDTO> getAllLibraryUsers() {
        return libraryUserService.getAllLibraryUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryUserDTO> getLibraryUserById(@PathVariable Long id) {
        try {
            LibraryUserDTO libraryUserDTO = libraryUserService.getLibraryUserById(id);
            return ResponseEntity.ok(libraryUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<LibraryUserDTO> saveLibraryUser(@RequestBody LibraryUserDTO libraryUserDTO) {
        LibraryUserDTO savedLibraryUserDTO = libraryUserService.saveLibraryUser(libraryUserDTO);
        return ResponseEntity.status(201).body(savedLibraryUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryUser(@PathVariable Long id) {
        try {
            libraryUserService.deleteLibraryUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<LibraryUserDTO> findLibraryUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return libraryUserService.findLibraryUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<LibraryUserDTO> findLibraryUsersByEmail(@RequestParam String email) {
        return libraryUserService.findLibraryUsersByEmail(email);
    }

    @GetMapping("/search/library/{libraryId}")
    public List<LibraryUserDTO> findLibraryUsersByLibraryId(@PathVariable Long libraryId) {
        return libraryUserService.findLibraryUsersByLibraryId(libraryId);
    }

    @GetMapping("/search/branch/{branchId}")
    public List<LibraryUserDTO> findLibraryUsersByBranchId(@PathVariable Long branchId) {
        return libraryUserService.findLibraryUsersByBranchId(branchId);
    }
}
