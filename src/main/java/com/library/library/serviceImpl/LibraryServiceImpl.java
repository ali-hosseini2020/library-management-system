package com.library.library.serviceImpl;
import com.library.exception.ResourceNotFoundException;
import com.library.library.Library;
import com.library.library.dto.LibraryDTO;
import com.library.library.mapper.LibraryMapper;
import com.library.library.repository.LibraryRepository;
import com.library.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private LibraryMapper libraryMapper;

    @Override
    public List<LibraryDTO> getAllLibraries() {
        List<Library> libraries = libraryRepository.findAll();
        return libraries.stream()
                .map(libraryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDTO getLibraryById(Long id) {
        Library library = libraryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library not found with id " + id));
        return libraryMapper.toDTO(library);
    }

    @Override
    public LibraryDTO saveLibrary(LibraryDTO libraryDTO) {
        Library library = libraryMapper.toEntity(libraryDTO);
        Library savedLibrary = libraryRepository.save(library);
        return libraryMapper.toDTO(savedLibrary);
    }

    @Override
    public void deleteLibrary(Long id) {
        if (!libraryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library not found with id " + id);
        }
        libraryRepository.deleteById(id);
    }

    @Override
    public List<LibraryDTO> findLibrariesByName(String name) {
        List<Library> libraries = libraryRepository.findByNameContaining(name);
        return libraries.stream()
                .map(libraryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryDTO> findLibrariesByAddress(String address) {
        List<Library> libraries = libraryRepository.findByAddressContaining(address);
        return libraries.stream()
                .map(libraryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
