package com.library.library.serviceImpl;

import com.library.library.LibraryMembership;
import com.library.library.dto.LibraryMembershipDTO;
import com.library.library.mapper.LibraryMembershipMapper;
import com.library.library.repository.LibraryMembershipRepository;
import com.library.library.service.LibraryMembershipService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryMembershipServiceImpl implements LibraryMembershipService {

    @Autowired
    private LibraryMembershipRepository libraryMembershipRepository;

    @Autowired
    private LibraryMembershipMapper libraryMembershipMapper;

    @Override
    public List<LibraryMembershipDTO> getAllLibraryMemberships() {
        List<LibraryMembership> libraryMemberships = libraryMembershipRepository.findAll();
        return libraryMemberships.stream()
                .map(libraryMembershipMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryMembershipDTO getLibraryMembershipById(Long id) {
        LibraryMembership libraryMembership = libraryMembershipRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library membership not found with id " + id));
        return libraryMembershipMapper.toDTO(libraryMembership);
    }

    @Override
    public LibraryMembershipDTO saveLibraryMembership(LibraryMembershipDTO libraryMembershipDTO) {
        LibraryMembership libraryMembership = libraryMembershipMapper.toEntity(libraryMembershipDTO);
        LibraryMembership savedLibraryMembership = libraryMembershipRepository.save(libraryMembership);
        return libraryMembershipMapper.toDTO(savedLibraryMembership);
    }

    @Override
    public void deleteLibraryMembership(Long id) {
        if (!libraryMembershipRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library membership not found with id " + id);
        }
        libraryMembershipRepository.deleteById(id);
    }

    @Override
    public List<LibraryMembershipDTO> findActiveMembershipsByUserId(Long userId) {
        List<LibraryMembership> libraryMemberships = libraryMembershipRepository.findActiveMembershipsByUserId(userId);
        return libraryMemberships.stream()
                .map(libraryMembershipMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryMembershipDTO> findInactiveMembershipsByUserId(Long userId) {
        List<LibraryMembership> libraryMemberships = libraryMembershipRepository.findInactiveMembershipsByUserId(userId);
        return libraryMemberships.stream()
                .map(libraryMembershipMapper::toDTO)
                .collect(Collectors.toList());
    }
}
