package com.library.book.controller;

import com.library.book.dto.BookSeriesDTO;
import com.library.book.service.BookSeriesService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-series")
public class BookSeriesController {

    @Autowired
    private BookSeriesService bookSeriesService;

    @GetMapping
    public List<BookSeriesDTO> getAllBookSeries() {
        return bookSeriesService.getAllBookSeries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookSeriesDTO> getBookSeriesById(@PathVariable Long id) {
        try {
            BookSeriesDTO bookSeriesDTO = bookSeriesService.getBookSeriesById(id);
            return ResponseEntity.ok(bookSeriesDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookSeriesDTO> saveBookSeries(@RequestBody BookSeriesDTO bookSeriesDTO) {
        BookSeriesDTO savedBookSeriesDTO = bookSeriesService.saveBookSeries(bookSeriesDTO);
        return ResponseEntity.status(201).body(savedBookSeriesDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookSeries(@PathVariable Long id) {
        try {
            bookSeriesService.deleteBookSeries(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<BookSeriesDTO> findBookSeriesByName(@RequestParam String name) {
        return bookSeriesService.findBookSeriesByName(name);
    }
}
