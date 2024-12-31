package com.library.fine.service;
import com.library.fine.dto.FineStatusDTO;
import java.util.List;

public interface FineStatusService {
    List<FineStatusDTO> getAllFineStatuses();
    FineStatusDTO getFineStatusById(Long id);
    FineStatusDTO saveFineStatus(FineStatusDTO fineStatusDTO);
    void deleteFineStatus(Long id);
    List<FineStatusDTO> findFineStatusesByFineId(Long fineId);
}
