package com.library.book.serviceImpl;

import com.library.book.BookSeries;
import com.library.book.dto.BookSeriesDTO;
import com.library.book.mapper.BookSeriesMapper;
import com.library.book.repository.BookSeriesRepository;
import com.library.book.service.BookSeriesService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookSeriesServiceImpl implements BookSeriesService {

    @Autowired
    private BookSeriesRepository bookSeriesRepository;

    @Autowired
    private BookSeriesMapper bookSeriesMapper;

    @Override
    public List<BookSeriesDTO> getAllBookSeries() {
        List<BookSeries> bookSeries = bookSeriesRepository.findAll();
        return bookSeries.stream()
                .map(bookSeriesMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookSeriesDTO getBookSeriesById(Long id) {
        BookSeries bookSeries = bookSeriesRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book series not found with id " + id));
        return bookSeriesMapper.toDTO(bookSeries);
    }

    @Override
    public BookSeriesDTO saveBookSeries(BookSeriesDTO bookSeriesDTO) {
        BookSeries bookSeries = bookSeriesMapper.toEntity(bookSeriesDTO);
        BookSeries savedBookSeries = bookSeriesRepository.save(bookSeries);
        return bookSeriesMapper.toDTO(savedBookSeries);
    }

    @Override
    public void deleteBookSeries(Long id) {
        if (!bookSeriesRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book series not found with id " + id);
        }
        bookSeriesRepository.deleteById(id);
    }

    @Override
    public List<BookSeriesDTO> findBookSeriesByName(String name) {
        List<BookSeries> bookSeries = bookSeriesRepository.findBySeriesNameContaining(name);
        return bookSeries.stream()
                .map(bookSeriesMapper::toDTO)
                .collect(Collectors.toList());
    }
}
