package com.library.book.controller;

import com.library.book.dto.BookEditionDTO;
import com.library.book.service.BookEditionService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-editions")
public class BookEditionController {

    @Autowired
    private BookEditionService bookEditionService;

    @GetMapping
    public List<BookEditionDTO> getAllBookEditions() {
        return bookEditionService.getAllBookEditions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookEditionDTO> getBookEditionById(@PathVariable Long id) {
        try {
            BookEditionDTO bookEditionDTO = bookEditionService.getBookEditionById(id);
            return ResponseEntity.ok(bookEditionDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookEditionDTO> saveBookEdition(@RequestBody BookEditionDTO bookEditionDTO) {
        BookEditionDTO savedBookEditionDTO = bookEditionService.saveBookEdition(bookEditionDTO);
        return ResponseEntity.status(201).body(savedBookEditionDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookEdition(@PathVariable Long id) {
        try {
            bookEditionService.deleteBookEdition(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<BookEditionDTO> findBookEditionsByName(@RequestParam String name) {
        return bookEditionService.findBookEditionsByName(name);
    }
}
