package com.library.book.serviceImpl;

import com.library.book.BookEdition;
import com.library.book.dto.BookEditionDTO;
import com.library.book.mapper.BookEditionMapper;
import com.library.book.repository.BookEditionRepository;
import com.library.book.service.BookEditionService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookEditionServiceImpl implements BookEditionService {

    @Autowired
    private BookEditionRepository bookEditionRepository;

    @Autowired
    private BookEditionMapper bookEditionMapper;

    @Override
    public List<BookEditionDTO> getAllBookEditions() {
        List<BookEdition> bookEditions = bookEditionRepository.findAll();
        return bookEditions.stream()
                .map(bookEditionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookEditionDTO getBookEditionById(Long id) {
        BookEdition bookEdition = bookEditionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book edition not found with id " + id));
        return bookEditionMapper.toDTO(bookEdition);
    }

    @Override
    public BookEditionDTO saveBookEdition(BookEditionDTO bookEditionDTO) {
        BookEdition bookEdition = bookEditionMapper.toEntity(bookEditionDTO);
        BookEdition savedBookEdition = bookEditionRepository.save(bookEdition);
        return bookEditionMapper.toDTO(savedBookEdition);
    }

    @Override
    public void deleteBookEdition(Long id) {
        if (!bookEditionRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book edition not found with id " + id);
        }
        bookEditionRepository.deleteById(id);
    }

    @Override
    public List<BookEditionDTO> findBookEditionsByName(String name) {
        List<BookEdition> bookEditions = bookEditionRepository.findByEditionNameContaining(name);
        return bookEditions.stream()
                .map(bookEditionMapper::toDTO)
                .collect(Collectors.toList());
    }
}
