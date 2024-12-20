package com.library.book.service;

import com.library.book.dto.BookTagDTO;

import java.util.List;

public interface BookTagService {
    List<BookTagDTO> getAllBookTags();
    BookTagDTO getBookTagById(Long id);
    BookTagDTO saveBookTag(BookTagDTO bookTagDTO);
    void deleteBookTag(Long id);
    List<BookTagDTO> findBookTagsByName(String name);
}
