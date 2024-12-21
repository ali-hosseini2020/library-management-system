package com.library.library.service;
import com.library.library.dto.LibraryMembershipDTO;
import java.util.List;

public interface LibraryMembershipService {
    List<LibraryMembershipDTO> getAllLibraryMemberships();
    LibraryMembershipDTO getLibraryMembershipById(Long id);
    LibraryMembershipDTO saveLibraryMembership(LibraryMembershipDTO libraryMembershipDTO);
    void deleteLibraryMembership(Long id);
    List<LibraryMembershipDTO> findActiveMembershipsByUserId(Long userId);
    List<LibraryMembershipDTO> findInactiveMembershipsByUserId(Long userId);
}
