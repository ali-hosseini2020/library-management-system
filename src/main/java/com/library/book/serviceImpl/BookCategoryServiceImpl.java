package com.library.book.serviceImpl;

import com.library.book.BookCategory;
import com.library.book.dto.BookCategoryDTO;
import com.library.book.mapper.BookCategoryMapper;
import com.library.book.repository.BookCategoryRepository;
import com.library.book.service.BookCategoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {

    @Autowired
    private BookCategoryRepository bookCategoryRepository;

    @Autowired
    private BookCategoryMapper bookCategoryMapper;

    @Override
    public List<BookCategoryDTO> getAllBookCategories() {
        List<BookCategory> bookCategories = bookCategoryRepository.findAll();
        return bookCategories.stream()
                .map(bookCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookCategoryDTO getBookCategoryById(Long id) {
        BookCategory bookCategory = bookCategoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book category not found with id " + id));
        return bookCategoryMapper.toDTO(bookCategory);
    }

    @Override
    public BookCategoryDTO saveBookCategory(BookCategoryDTO bookCategoryDTO) {
        BookCategory bookCategory = bookCategoryMapper.toEntity(bookCategoryDTO);
        BookCategory savedBookCategory = bookCategoryRepository.save(bookCategory);
        return bookCategoryMapper.toDTO(savedBookCategory);
    }

    @Override
    public void deleteBookCategory(Long id) {
        if (!bookCategoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Book category not found with id " + id);
        }
        bookCategoryRepository.deleteById(id);
    }

    @Override
    public List<BookCategoryDTO> findBookCategoriesByName(String name) {
        List<BookCategory> bookCategories = bookCategoryRepository.findByNameContaining(name);
        return bookCategories.stream()
                .map(bookCategoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
