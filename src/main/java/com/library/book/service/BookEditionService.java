package com.library.book.service;

import com.library.book.dto.BookEditionDTO;

import java.util.List;

public interface BookEditionService {
    List<BookEditionDTO> getAllBookEditions();
    BookEditionDTO getBookEditionById(Long id);
    BookEditionDTO saveBookEdition(BookEditionDTO bookEditionDTO);
    void deleteBookEdition(Long id);
    List<BookEditionDTO> findBookEditionsByName(String name);
}
