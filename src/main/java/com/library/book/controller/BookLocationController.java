package com.library.book.controller;

import com.library.book.dto.BookLocationDTO;
import com.library.book.service.BookLocationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-locations")
public class BookLocationController {

    @Autowired
    private BookLocationService bookLocationService;

    @GetMapping
    public List<BookLocationDTO> getAllBookLocations() {
        return bookLocationService.getAllBookLocations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookLocationDTO> getBookLocationById(@PathVariable Long id) {
        try {
            BookLocationDTO bookLocationDTO = bookLocationService.getBookLocationById(id);
            return ResponseEntity.ok(bookLocationDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookLocationDTO> saveBookLocation(@RequestBody BookLocationDTO bookLocationDTO) {
        BookLocationDTO savedBookLocationDTO = bookLocationService.saveBookLocation(bookLocationDTO);
        return ResponseEntity.status(201).body(savedBookLocationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookLocation(@PathVariable Long id) {
        try {
            bookLocationService.deleteBookLocation(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/shelf")
    public List<BookLocationDTO> findBookLocationsByShelf(@RequestParam String shelf) {
        return bookLocationService.findBookLocationsByShelf(shelf);
    }

    @GetMapping("/search/section")
    public List<BookLocationDTO> findBookLocationsBySection(@RequestParam String section) {
        return bookLocationService.findBookLocationsBySection(section);
    }
}
