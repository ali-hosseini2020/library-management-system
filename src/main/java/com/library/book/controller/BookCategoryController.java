package com.library.book.controller;

import com.library.book.dto.BookCategoryDTO;
import com.library.book.service.BookCategoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @GetMapping
    public List<BookCategoryDTO> getAllBookCategories() {
        return bookCategoryService.getAllBookCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCategoryDTO> getBookCategoryById(@PathVariable Long id) {
        try {
            BookCategoryDTO bookCategoryDTO = bookCategoryService.getBookCategoryById(id);
            return ResponseEntity.ok(bookCategoryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<BookCategoryDTO> saveBookCategory(@RequestBody BookCategoryDTO bookCategoryDTO) {
        BookCategoryDTO savedBookCategoryDTO = bookCategoryService.saveBookCategory(bookCategoryDTO);
        return ResponseEntity.status(201).body(savedBookCategoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable Long id) {
        try {
            bookCategoryService.deleteBookCategory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search")
    public List<BookCategoryDTO> findBookCategoriesByName(@RequestParam String name) {
        return bookCategoryService.findBookCategoriesByName(name);
    }
}
