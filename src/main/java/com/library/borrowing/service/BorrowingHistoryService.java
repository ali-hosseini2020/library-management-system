package com.library.borrowing.service;
import com.library.borrowing.dto.BorrowingHistoryDTO;
import java.util.List;

public interface BorrowingHistoryService {
    List<BorrowingHistoryDTO> getAllBorrowingHistories();
    BorrowingHistoryDTO getBorrowingHistoryById(Long id);
    BorrowingHistoryDTO saveBorrowingHistory(BorrowingHistoryDTO borrowingHistoryDTO);
    void deleteBorrowingHistory(Long id);
    List<BorrowingHistoryDTO> findBorrowingHistoriesByBorrowingId(Long borrowingId);
}
