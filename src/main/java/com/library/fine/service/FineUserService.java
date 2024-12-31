package com.library.fine.service;
import com.library.fine.dto.FineUserDTO;
import java.util.List;

public interface FineUserService {
    List<FineUserDTO> getAllFineUsers();
    FineUserDTO getFineUserById(Long id);
    FineUserDTO saveFineUser(FineUserDTO fineUserDTO);
    void deleteFineUser(Long id);
    List<FineUserDTO> findFineUsersByName(String firstName, String lastName);
    List<FineUserDTO> findFineUsersByEmail(String email);
}

