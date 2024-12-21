package com.library.library.service;
import com.library.library.dto.LibraryDTO;

import java.util.List;

public interface LibraryService {
    List<LibraryDTO> getAllLibraries();
    LibraryDTO getLibraryById(Long id);
    LibraryDTO saveLibrary(LibraryDTO libraryDTO);
    void deleteLibrary(Long id);
    List<LibraryDTO> findLibrariesByName(String name);
    List<LibraryDTO> findLibrariesByAddress(String address);
}
