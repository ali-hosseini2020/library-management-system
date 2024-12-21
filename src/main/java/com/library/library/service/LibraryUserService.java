package com.library.library.service;
import com.library.library.dto.LibraryUserDTO;
import java.util.List;

public interface LibraryUserService {
    List<LibraryUserDTO> getAllLibraryUsers();
    LibraryUserDTO getLibraryUserById(Long id);
    LibraryUserDTO saveLibraryUser(LibraryUserDTO libraryUserDTO);
    void deleteLibraryUser(Long id);
    List<LibraryUserDTO> findLibraryUsersByName(String firstName, String lastName);
    List<LibraryUserDTO> findLibraryUsersByEmail(String email);
    List<LibraryUserDTO> findLibraryUsersByLibraryId(Long libraryId);
    List<LibraryUserDTO> findLibraryUsersByBranchId(Long branchId);
}