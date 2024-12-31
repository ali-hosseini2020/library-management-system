package com.library.fine.service;
import com.library.fine.dto.FineItemDTO;
import java.util.List;

public interface FineItemService {
    List<FineItemDTO> getAllFineItems();
    FineItemDTO getFineItemById(Long id);
    FineItemDTO saveFineItem(FineItemDTO fineItemDTO);
    void deleteFineItem(Long id);
    List<FineItemDTO> findFineItemsByFineId(Long fineId);
}
