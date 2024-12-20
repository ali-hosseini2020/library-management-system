package com.library.book.serviceImpl;

import com.library.book.BookTag;
import com.library.book.dto.BookTagDTO;
import com.library.book.mapper.BookTagMapper;
import com.library.book.repository.BookTagRepository;
import com.library.book.service.BookTagService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookTagServiceImpl implements BookTagService {

    @Autowired
    private BookTagRepository bookTagRepository;

    @Autowired
    private BookTagMapper bookTagMapper;

    @Override
    public List<BookTagDTO> getAllBookTags() {
        List<BookTag> bookTags = bookTagRepository.findAll();
        return bookTags.stream()
                .map(bookTagMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookTagDTO getBookTagById(Long id) {
        BookTag bookTag = bookTagRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book tag not found with id " + id));
        return bookTagMapper.toDTO(bookTag);
    }

    @Override
    public BookTagDTO saveBookTag(BookTagDTO bookTagDTO) {
        BookTag bookTag = bookTagMapper.toEntity(bookTagDTO);
        BookTag savedBookTag = bookTagRepository.save(bookTag);
        return bookTagMapper.toDTO(savedBookTag);
    }

    @Override
    public void deleteBookTag(Long id) {
        if (!bookTagRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book tag not found with id " + id);
        }
        bookTagRepository.deleteById(id);
    }

    @Override
    public List<BookTagDTO> findBookTagsByName(String name) {
        List<BookTag> bookTags = bookTagRepository.findByNameContaining(name);
        return bookTags.stream()
                .map(bookTagMapper::toDTO)
                .collect(Collectors.toList());
    }
}
