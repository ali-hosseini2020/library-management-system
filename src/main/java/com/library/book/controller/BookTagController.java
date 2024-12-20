package com.library.book.controller;

import com.library.book.dto.BookTagDTO;
import com.library.book.service.BookTagService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-tags")
public class BookTagController {

    @Autowired
    private BookTagService bookTagService;

    @GetMapping
    public List<BookTagDTO> getAllBookTags() {
        return bookTagService.getAllBookTags();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookTagDTO> getBookTagById(@PathVariable Long id) {
        try {
            BookTagDTO bookTagDTO = bookTagService.getBookTagById(id);
            return ResponseEntity.ok(bookTagDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookTagDTO> saveBookTag(@RequestBody BookTagDTO bookTagDTO) {
        BookTagDTO savedBookTagDTO = bookTagService.saveBookTag(bookTagDTO);
        return ResponseEntity.status(201).body(savedBookTagDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookTag(@PathVariable Long id) {
        try {
            bookTagService.deleteBookTag(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<BookTagDTO> findBookTagsByName(@RequestParam String name) {
        return bookTagService.findBookTagsByName(name);
    }
}
