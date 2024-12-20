package com.library.book.service;

import com.library.book.dto.BookLocationDTO;

import java.util.List;

public interface BookLocationService {
    List<BookLocationDTO> getAllBookLocations();
    BookLocationDTO getBookLocationById(Long id);
    BookLocationDTO saveBookLocation(BookLocationDTO bookLocationDTO);
    void deleteBookLocation(Long id);
    List<BookLocationDTO> findBookLocationsByShelf(String shelf);
    List<BookLocationDTO> findBookLocationsBySection(String section);
}
