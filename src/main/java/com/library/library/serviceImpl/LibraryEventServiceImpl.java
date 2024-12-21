package com.library.library.serviceImpl;
import com.library.library.LibraryEvent;
import com.library.library.dto.LibraryEventDTO;
import com.library.library.mapper.LibraryEventMapper;
import com.library.library.repository.LibraryEventRepository;
import com.library.library.service.LibraryEventService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibraryEventServiceImpl implements LibraryEventService {

    @Autowired
    private LibraryEventRepository libraryEventRepository;

    @Autowired
    private LibraryEventMapper libraryEventMapper;

    @Override
    public List<LibraryEventDTO> getAllLibraryEvents() {
        List<LibraryEvent> libraryEvents = libraryEventRepository.findAll();
        return libraryEvents.stream()
                .map(libraryEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryEventDTO getLibraryEventById(Long id) {
        LibraryEvent libraryEvent = libraryEventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Library event not found with id " + id));
        return libraryEventMapper.toDTO(libraryEvent);
    }

    @Override
    public LibraryEventDTO saveLibraryEvent(LibraryEventDTO libraryEventDTO) {
        LibraryEvent libraryEvent = libraryEventMapper.toEntity(libraryEventDTO);
        LibraryEvent savedLibraryEvent = libraryEventRepository.save(libraryEvent);
        return libraryEventMapper.toDTO(savedLibraryEvent);
    }

    @Override
    public void deleteLibraryEvent(Long id) {
        if (!libraryEventRepository.existsById(id)) {
            throw new ResourceNotFoundException("Library event not found with id " + id);
        }
        libraryEventRepository.deleteById(id);
    }

    @Override
    public List<LibraryEventDTO> findLibraryEventsByName(String name) {
        List<LibraryEvent> libraryEvents = libraryEventRepository.findByNameContaining(name);
        return libraryEvents.stream()
                .map(libraryEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryEventDTO> findLibraryEventsByLibraryId(Long libraryId) {
        List<LibraryEvent> libraryEvents = libraryEventRepository.findByLibraryId(libraryId);
        return libraryEvents.stream()
                .map(libraryEventMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<LibraryEventDTO> findLibraryEventsByBranchId(Long branchId) {
        List<LibraryEvent> libraryEvents = libraryEventRepository.findByBranchId(branchId);
        return libraryEvents.stream()
                .map(libraryEventMapper::toDTO)
                .collect(Collectors.toList());
    }
}