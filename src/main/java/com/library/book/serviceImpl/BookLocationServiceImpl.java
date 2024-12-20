package com.library.book.serviceImpl;

import com.library.book.BookLocation;
import com.library.book.dto.BookLocationDTO;
import com.library.book.mapper.BookLocationMapper;
import com.library.book.repository.BookLocationRepository;
import com.library.book.service.BookLocationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookLocationServiceImpl implements BookLocationService {

    @Autowired
    private BookLocationRepository bookLocationRepository;

    @Autowired
    private BookLocationMapper bookLocationMapper;

    @Override
    public List<BookLocationDTO> getAllBookLocations() {
        List<BookLocation> bookLocations = bookLocationRepository.findAll();
        return bookLocations.stream()
                .map(bookLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookLocationDTO getBookLocationById(Long id) {
        BookLocation bookLocation = bookLocationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book location not found with id " + id));
        return bookLocationMapper.toDTO(bookLocation);
    }

    @Override
    public BookLocationDTO saveBookLocation(BookLocationDTO bookLocationDTO) {
        BookLocation bookLocation = bookLocationMapper.toEntity(bookLocationDTO);
        BookLocation savedBookLocation = bookLocationRepository.save(bookLocation);
        return bookLocationMapper.toDTO(savedBookLocation);
    }

    @Override
    public void deleteBookLocation(Long id) {
        if (!bookLocationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book location not found with id " + id);
        }
        bookLocationRepository.deleteById(id);
    }

    @Override
    public List<BookLocationDTO> findBookLocationsByShelf(String shelf) {
        List<BookLocation> bookLocations = bookLocationRepository.findByShelfContaining(shelf);
        return bookLocations.stream()
                .map(bookLocationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookLocationDTO> findBookLocationsBySection(String section) {
        List<BookLocation> bookLocations = bookLocationRepository.findBySectionContaining(section);
        return bookLocations.stream()
                .map(bookLocationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
