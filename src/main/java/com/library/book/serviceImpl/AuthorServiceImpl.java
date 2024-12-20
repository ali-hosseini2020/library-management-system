package com.library.book.serviceImpl;

import com.library.book.Author;
import com.library.book.dto.AuthorDTO;
import com.library.book.mapper.AuthorMapper;
import com.library.book.repository.AuthorRepository;
import com.library.book.service.AuthorService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return authors.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AuthorDTO getAuthorById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Author not found with id " + id));
        return authorMapper.toDTO(author);
    }

    @Override
    public AuthorDTO saveAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.toEntity(authorDTO);
        Author savedAuthor = authorRepository.save(author);
        return authorMapper.toDTO(savedAuthor);
    }

    @Override
    public void deleteAuthor(Long id) {
        if (!authorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Author not found with id " + id);
        }
        authorRepository.deleteById(id);
    }

    @Override
    public List<AuthorDTO> findAuthorsByName(String firstName, String lastName) {
        List<Author> authors = authorRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return authors.stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }
}
