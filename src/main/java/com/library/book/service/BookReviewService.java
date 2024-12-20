package com.library.book.service;

import com.library.book.dto.BookReviewDTO;

import java.util.List;

public interface BookReviewService {
    List<BookReviewDTO> getAllBookReviews();
    BookReviewDTO getBookReviewById(Long id);
    BookReviewDTO saveBookReview(BookReviewDTO bookReviewDTO);
    void deleteBookReview(Long id);
    List<BookReviewDTO> findBookReviewsByBookId(Long bookId);
    List<BookReviewDTO> findBookReviewsByUserId(Long userId);
}
