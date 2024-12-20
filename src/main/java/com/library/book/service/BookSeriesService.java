package com.library.book.service;

import com.library.book.dto.BookSeriesDTO;

import java.util.List;

public interface BookSeriesService {
    List<BookSeriesDTO> getAllBookSeries();
    BookSeriesDTO getBookSeriesById(Long id);
    BookSeriesDTO saveBookSeries(BookSeriesDTO bookSeriesDTO);
    void deleteBookSeries(Long id);
    List<BookSeriesDTO> findBookSeriesByName(String name);
}
