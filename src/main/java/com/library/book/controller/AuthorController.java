package com.library.book.controller;

import com.library.book.dto.AuthorDTO;
import com.library.book.service.AuthorService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @GetMapping
    public List<AuthorDTO> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthorById(@PathVariable Long id) {
        try {
            AuthorDTO authorDTO = authorService.getAuthorById(id);
            return ResponseEntity.ok(authorDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<AuthorDTO> saveAuthor(@RequestBody AuthorDTO authorDTO) {
        AuthorDTO savedAuthorDTO = authorService.saveAuthor(authorDTO);
        return ResponseEntity.status(201).body(savedAuthorDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        try {
            authorService.deleteAuthor(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<AuthorDTO> findAuthorsByName(@RequestParam String firstName, @RequestParam String lastName) {
        return authorService.findAuthorsByName(firstName, lastName);
    }
}
