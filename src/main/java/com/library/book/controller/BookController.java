package com.library.book.controller;

import com.library.book.dto.BookDTO;
import com.library.book.service.BookService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        try {
            BookDTO bookDTO = bookService.getBookById(id);
            return ResponseEntity.ok(bookDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookDTO> saveBook(@RequestBody BookDTO bookDTO) {
        BookDTO savedBookDTO = bookService.saveBook(bookDTO);
        return ResponseEntity.status(201).body(savedBookDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/title")
    public List<BookDTO> findBooksByTitle(@RequestParam String title) {
        return bookService.findBooksByTitle(title);
    }

    @GetMapping("/search/status")
    public List<BookDTO> findBooksByStatus(@RequestParam String status) {
        return bookService.findBooksByStatus(status);
    }

    @GetMapping("/search/category/{categoryId}")
    public List<BookDTO> findBooksByCategoryId(@PathVariable Long categoryId) {
        return bookService.findBooksByCategoryId(categoryId);
    }

    @GetMapping("/search/location/{locationId}")
    public List<BookDTO> findBooksByLocationId(@PathVariable Long locationId) {
        return bookService.findBooksByLocationId(locationId);
    }

    @GetMapping("/search/tag/{tagId}")
    public List<BookDTO> findBooksByTagId(@PathVariable Long tagId) {
        return bookService.findBooksByTagId(tagId);
    }

    @GetMapping("/search/author/{authorId}")
    public List<BookDTO> findBooksByAuthorId(@PathVariable Long authorId) {
        return bookService.findBooksByAuthorId(authorId);
    }

    @GetMapping("/search/publisher/{publisherId}")
    public List<BookDTO> findBooksByPublisherId(@PathVariable Long publisherId) {
        return bookService.findBooksByPublisherId(publisherId);
    }

    @GetMapping("/search/series/{seriesId}")
    public List<BookDTO> findBooksBySeriesId(@PathVariable Long seriesId) {
        return bookService.findBooksBySeriesId(seriesId);
    }
}
