package com.library.fine.service;
import com.library.fine.dto.FineDTO;
import java.util.List;

public interface FineService {
    List<FineDTO> getAllFines();
    FineDTO getFineById(Long id);
    FineDTO saveFine(FineDTO fineDTO);
    void deleteFine(Long id);
    List<FineDTO> findFinesByUserId(Long userId);
    List<FineDTO> findFinesByStatus(String status);
}
