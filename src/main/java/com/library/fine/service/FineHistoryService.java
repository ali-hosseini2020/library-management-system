package com.library.fine.service;

import com.library.fine.dto.FineHistoryDTO;

import java.util.List;

public interface FineHistoryService {
    List<FineHistoryDTO> getAllFineHistories();
    FineHistoryDTO getFineHistoryById(Long id);
    FineHistoryDTO saveFineHistory(FineHistoryDTO fineHistoryDTO);
    void deleteFineHistory(Long id);
    List<FineHistoryDTO> findFineHistoriesByFineId(Long fineId);
}
