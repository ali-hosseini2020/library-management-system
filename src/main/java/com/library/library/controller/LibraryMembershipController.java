package com.library.library.controller;
import com.library.library.dto.LibraryMembershipDTO;
import com.library.library.service.LibraryMembershipService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/library-memberships")
public class LibraryMembershipController {

    @Autowired
    private LibraryMembershipService libraryMembershipService;

    @GetMapping
    public List<LibraryMembershipDTO> getAllLibraryMemberships() {
        return libraryMembershipService.getAllLibraryMemberships();
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryMembershipDTO> getLibraryMembershipById(@PathVariable Long id) {
        try {
            LibraryMembershipDTO libraryMembershipDTO = libraryMembershipService.getLibraryMembershipById(id);
            return ResponseEntity.ok(libraryMembershipDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<LibraryMembershipDTO> saveLibraryMembership(@RequestBody LibraryMembershipDTO libraryMembershipDTO) {
        LibraryMembershipDTO savedLibraryMembershipDTO = libraryMembershipService.saveLibraryMembership(libraryMembershipDTO);
        return ResponseEntity.status(201).body(savedLibraryMembershipDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryMembership(@PathVariable Long id) {
        try {
            libraryMembershipService.deleteLibraryMembership(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/active/{userId}")
    public List<LibraryMembershipDTO> findActiveMembershipsByUserId(@PathVariable Long userId) {
        return libraryMembershipService.findActiveMembershipsByUserId(userId);
    }

    @GetMapping("/search/inactive/{userId}")
    public List<LibraryMembershipDTO> findInactiveMembershipsByUserId(@PathVariable Long userId) {
        return libraryMembershipService.findInactiveMembershipsByUserId(userId);
    }
}

