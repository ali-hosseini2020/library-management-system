package com.library.book.controller;

import com.library.book.dto.BookReviewDTO;
import com.library.book.service.BookReviewService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-reviews")
public class BookReviewController {

    @Autowired
    private BookReviewService bookReviewService;

    @GetMapping
    public List<BookReviewDTO> getAllBookReviews() {
        return bookReviewService.getAllBookReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReviewDTO> getBookReviewById(@PathVariable Long id) {
        try {
            BookReviewDTO bookReviewDTO = bookReviewService.getBookReviewById(id);
            return ResponseEntity.ok(bookReviewDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookReviewDTO> saveBookReview(@RequestBody BookReviewDTO bookReviewDTO) {
        BookReviewDTO savedBookReviewDTO = bookReviewService.saveBookReview(bookReviewDTO);
        return ResponseEntity.status(201).body(savedBookReviewDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookReview(@PathVariable Long id) {
        try {
            bookReviewService.deleteBookReview(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/book/{bookId}")
    public List<BookReviewDTO> findBookReviewsByBookId(@PathVariable Long bookId) {
        return bookReviewService.findBookReviewsByBookId(bookId);
    }

    @GetMapping("/search/user/{userId}")
    public List<BookReviewDTO> findBookReviewsByUserId(@PathVariable Long userId) {
        return bookReviewService.findBookReviewsByUserId(userId);
    }
}
