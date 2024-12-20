package com.library.book.service;

import com.library.book.dto.BookCategoryDTO;

import java.util.List;

public interface BookCategoryService {
    List<BookCategoryDTO> getAllBookCategories();
    BookCategoryDTO getBookCategoryById(Long id);
    BookCategoryDTO saveBookCategory(BookCategoryDTO bookCategoryDTO);
    void deleteBookCategory(Long id);
    List<BookCategoryDTO> findBookCategoriesByName(String name);
}
