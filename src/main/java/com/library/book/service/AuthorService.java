package com.library.book.service;

import com.library.book.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {
    List<AuthorDTO> getAllAuthors();
    AuthorDTO getAuthorById(Long id);
    AuthorDTO saveAuthor(AuthorDTO authorDTO);
    void deleteAuthor(Long id);
    List<AuthorDTO> findAuthorsByName(String firstName, String lastName);
}
