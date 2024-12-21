package com.library.library.serviceImpl;
import com.library.library.LibraryBranch;
import com.library.library.dto.LibraryBranchDTO;
import com.library.library.mapper.LibraryBranchMapper;
import com.library.library.repository.LibraryBranchRepository;
import com.library.library.service.LibraryBranchService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class LibraryBranchServiceImpl implements LibraryBranchService {

    @Autowired
    private LibraryBranchRepository libraryBranchRepository;

    @Autowired
    private LibraryBranchMapper libraryBranchMapper;

    @Override
    public List<LibraryBranchDTO> getAllLibraryBranches() {
        List<LibraryBranch> libraryBranches = libraryBranchRepository.findAll();
        return libraryBranches.stream()
                .map(libraryBranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryBranchDTO getLibraryBranchById(Long id) {
        LibraryBranch libraryBranch = libraryBranchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library branch not found with id " + id));
        return libraryBranchMapper.toDTO(libraryBranch);
    }

    @Override
    public LibraryBranchDTO saveLibraryBranch(LibraryBranchDTO libraryBranchDTO) {
        LibraryBranch libraryBranch = libraryBranchMapper.toEntity(libraryBranchDTO);
        LibraryBranch savedLibraryBranch = libraryBranchRepository.save(libraryBranch);
        return libraryBranchMapper.toDTO(savedLibraryBranch);
    }

    @Override
    public void deleteLibraryBranch(Long id) {
        if (!libraryBranchRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library branch not found with id " + id);
        }
        libraryBranchRepository.deleteById(id);
    }

    @Override
    public List<LibraryBranchDTO> findLibraryBranchesByName(String name) {
        List<LibraryBranch> libraryBranches = libraryBranchRepository.findByNameContaining(name);
        return libraryBranches.stream()
                .map(libraryBranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryBranchDTO> findLibraryBranchesByAddress(String address) {
        List<LibraryBranch> libraryBranches = libraryBranchRepository.findByAddressContaining(address);
        return libraryBranches.stream()
                .map(libraryBranchMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryBranchDTO> findLibraryBranchesByLibraryId(Long libraryId) {
        List<LibraryBranch> libraryBranches = libraryBranchRepository.findByLibraryId(libraryId);
        return libraryBranches.stream()
                .map(libraryBranchMapper::toDTO)
                .collect(Collectors.toList());
    }
}