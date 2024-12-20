package com.library.book.serviceImpl;

import com.library.book.Book;
import com.library.book.dto.BookDTO;
import com.library.book.mapper.BookMapper;
import com.library.book.repository.BookRepository;
import com.library.book.service.BookService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id " + id));
        return bookMapper.toDTO(book);
    }

    @Override
    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = bookMapper.toEntity(bookDTO);
        Book savedBook = bookRepository.save(book);
        return bookMapper.toDTO(savedBook);
    }

    @Override
    public void deleteBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book not found with id " + id);
        }
        bookRepository.deleteById(id);
    }

    @Override
    public List<BookDTO> findBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContaining(title);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByStatus(String status) {
        List<Book> books = bookRepository.findByStatus(status);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByCategoryId(Long categoryId) {
        List<Book> books = bookRepository.findByCategoryId(categoryId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByLocationId(Long locationId) {
        List<Book> books = bookRepository.findByLocationId(locationId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByTagId(Long tagId) {
        List<Book> books = bookRepository.findByTagId(tagId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByAuthorId(Long authorId) {
        List<Book> books = bookRepository.findByAuthorId(authorId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksByPublisherId(Long publisherId) {
        List<Book> books = bookRepository.findByPublisherId(publisherId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBooksBySeriesId(Long seriesId) {
        List<Book> books = bookRepository.findBySeriesId(seriesId);
        return books.stream()
                .map(bookMapper::toDTO)
                .collect(Collectors.toList());
    }
}
