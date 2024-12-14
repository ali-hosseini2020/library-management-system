package com.library.book2;

import com.library.book2.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Override
    public BookDTO createBook(BookDTO bookDTO) {
        Book book = convertToEntity(bookDTO);
        book = bookRepository.save(book);
        return convertToDTO(book);
    }

    @Override
    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        return bookRepository.findById(id)
                .map(book -> {
                    book.setTitle(bookDTO.getTitle());
                    book.setIsbn(bookDTO.getIsbn());
                    book.setYearPublished(bookDTO.getYearPublished());
                    book.setCategory(bookDTO.getCategory());
                    book.setLocation(bookDTO.getLocation());
                    book.setTags(bookDTO.getTags());
                    book.setReviews(bookDTO.getReviews());
                    book.setEdition(bookDTO.getEdition());
                    book.setAuthors(bookDTO.getAuthors());
                    book.setPublisher(bookDTO.getPublisher());
                    book.setSeries(bookDTO.getSeries());
                    return convertToDTO(bookRepository.save(book));
                })
                .orElse(null);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private BookDTO convertToDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setIsbn(book.getIsbn());
        bookDTO.setYearPublished(book.getYearPublished());
        bookDTO.setCategory(book.getCategory());
        bookDTO.setLocation(book.getLocation());
        bookDTO.setTags(book.getTags());
        bookDTO.setReviews(book.getReviews());
        bookDTO.setEdition(book.getEdition());
        bookDTO.setAuthors(book.getAuthors());
        bookDTO.setPublisher(book.getPublisher());
        bookDTO.setSeries(book.getSeries());
        return bookDTO;
    }

    private Book convertToEntity(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setIsbn(bookDTO.getIsbn());
        book.setYearPublished(bookDTO.getYearPublished());
        book.setCategory(bookDTO.getCategory());
        book.setLocation(bookDTO.getLocation());
        book.setTags(bookDTO.getTags());
        book.setReviews(bookDTO.getReviews());
        book.setEdition(bookDTO.getEdition());
        book.setAuthors(bookDTO.getAuthors());
        book.setPublisher(bookDTO.getPublisher());
        book.setSeries(bookDTO.getSeries());
        return book;
    }
}
