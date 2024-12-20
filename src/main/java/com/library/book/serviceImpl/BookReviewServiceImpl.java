package com.library.book.serviceImpl;

import com.library.book.BookReview;
import com.library.book.dto.BookReviewDTO;
import com.library.book.mapper.BookReviewMapper;
import com.library.book.repository.BookReviewRepository;
import com.library.book.service.BookReviewService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookReviewServiceImpl implements BookReviewService {

    @Autowired
    private BookReviewRepository bookReviewRepository;

    @Autowired
    private BookReviewMapper bookReviewMapper;

    @Override
    public List<BookReviewDTO> getAllBookReviews() {
        List<BookReview> bookReviews = bookReviewRepository.findAll();
        return bookReviews.stream()
                .map(bookReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookReviewDTO getBookReviewById(Long id) {
        BookReview bookReview = bookReviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book review not found with id " + id));
        return bookReviewMapper.toDTO(bookReview);
    }

    @Override
    public BookReviewDTO saveBookReview(BookReviewDTO bookReviewDTO) {
        BookReview bookReview = bookReviewMapper.toEntity(bookReviewDTO);
        BookReview savedBookReview = bookReviewRepository.save(bookReview);
        return bookReviewMapper.toDTO(savedBookReview);
    }

    @Override
    public void deleteBookReview(Long id) {
        if (!bookReviewRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book review not found with id " + id);
        }
        bookReviewRepository.deleteById(id);
    }

    @Override
    public List<BookReviewDTO> findBookReviewsByBookId(Long bookId) {
        List<BookReview> bookReviews = bookReviewRepository.findByBookId(bookId);
        return bookReviews.stream()
                .map(bookReviewMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookReviewDTO> findBookReviewsByUserId(Long userId) {
        List<BookReview> bookReviews = bookReviewRepository.findByUserId(userId);
        return bookReviews.stream()
                .map(bookReviewMapper::toDTO)
                .collect(Collectors.toList());
    }
}
