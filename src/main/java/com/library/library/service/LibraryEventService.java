package com.library.library.service;
import com.library.library.dto.LibraryEventDTO;
import java.util.List;

public interface LibraryEventService {
    List<LibraryEventDTO> getAllLibraryEvents();
    LibraryEventDTO getLibraryEventById(Long id);
    LibraryEventDTO saveLibraryEvent(LibraryEventDTO libraryEventDTO);
    void deleteLibraryEvent(Long id);
    List<LibraryEventDTO> findLibraryEventsByName(String name);
    List<LibraryEventDTO> findLibraryEventsByLibraryId(Long libraryId);
    List<LibraryEventDTO> findLibraryEventsByBranchId(Long branchId);
}
