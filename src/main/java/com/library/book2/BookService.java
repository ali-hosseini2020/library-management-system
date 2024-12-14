package com.library.book2;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();

    BookDTO getBookById(Long id);

    BookDTO createBook(BookDTO bookDTO);

    BookDTO updateBook(Long id, BookDTO bookDTO);

    void deleteBook(Long id);
}