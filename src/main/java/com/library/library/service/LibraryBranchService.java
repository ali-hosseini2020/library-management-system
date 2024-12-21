package com.library.library.service;
import com.library.library.dto.LibraryBranchDTO;
import java.util.List;

public interface LibraryBranchService {
    List<LibraryBranchDTO> getAllLibraryBranches();
    LibraryBranchDTO getLibraryBranchById(Long id);
    LibraryBranchDTO saveLibraryBranch(LibraryBranchDTO libraryBranchDTO);
    void deleteLibraryBranch(Long id);
    List<LibraryBranchDTO> findLibraryBranchesByName(String name);
    List<LibraryBranchDTO> findLibraryBranchesByAddress(String address);
    List<LibraryBranchDTO> findLibraryBranchesByLibraryId(Long libraryId);
}