package com.library.library.serviceImpl;
import com.library.library.LibraryUser;
import com.library.library.dto.LibraryUserDTO;
import com.library.library.mapper.LibraryUserMapper;
import com.library.library.repository.LibraryUserRepository;
import com.library.library.service.LibraryUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

    @Autowired
    private LibraryUserRepository libraryUserRepository;

    @Autowired
    private LibraryUserMapper libraryUserMapper;

    @Override
    public List<LibraryUserDTO> getAllLibraryUsers() {
        List<LibraryUser> libraryUsers = libraryUserRepository.findAll();
        return libraryUsers.stream()
                .map(libraryUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryUserDTO getLibraryUserById(Long id) {
        LibraryUser libraryUser = libraryUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library user not found with id " + id));
        return libraryUserMapper.toDTO(libraryUser);
    }

    @Override
    public LibraryUserDTO saveLibraryUser(LibraryUserDTO libraryUserDTO) {
        LibraryUser libraryUser = libraryUserMapper.toEntity(libraryUserDTO);
        LibraryUser savedLibraryUser = libraryUserRepository.save(libraryUser);
        return libraryUserMapper.toDTO(savedLibraryUser);
    }

    @Override
    public void deleteLibraryUser(Long id) {
        if (!libraryUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library user not found with id " + id);
        }
        libraryUserRepository.deleteById(id);
    }

    @Override
    public List<LibraryUserDTO> findLibraryUsersByName(String firstName, String lastName) {
        List<LibraryUser> libraryUsers = libraryUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return libraryUsers.stream()
                .map(libraryUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryUserDTO> findLibraryUsersByEmail(String email) {
        List<LibraryUser> libraryUsers = libraryUserRepository.findByEmailContaining(email);
        return libraryUsers.stream()
                .map(libraryUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryUserDTO> findLibraryUsersByLibraryId(Long libraryId) {
        List<LibraryUser> libraryUsers = libraryUserRepository.findByLibraryId(libraryId);
        return libraryUsers.stream()
                .map(libraryUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryUserDTO> findLibraryUsersByBranchId(Long branchId) {
        List<LibraryUser> libraryUsers = libraryUserRepository.findByBranchId(branchId);
        return libraryUsers.stream()
                .map(libraryUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}