package com.library.book.service;

import com.library.book.dto.BookDTO;

import java.util.List;

public interface BookService {
    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long id);
    BookDTO saveBook(BookDTO bookDTO);
    void deleteBook(Long id);
    List<BookDTO> findBooksByTitle(String title);
    List<BookDTO> findBooksByStatus(String status);
    List<BookDTO> findBooksByCategoryId(Long categoryId);
    List<BookDTO> findBooksByLocationId(Long locationId);
    List<BookDTO> findBooksByTagId(Long tagId);
    List<BookDTO> findBooksByAuthorId(Long authorId);
    List<BookDTO> findBooksByPublisherId(Long publisherId);
    List<BookDTO> findBooksBySeriesId(Long seriesId);
}
