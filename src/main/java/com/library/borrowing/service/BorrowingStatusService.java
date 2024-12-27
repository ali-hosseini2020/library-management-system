package com.library.borrowing.service;
import com.library.borrowing.dto.BorrowingStatusDTO;
import java.util.List;

public interface BorrowingStatusService {
    List<BorrowingStatusDTO> getAllBorrowingStatuses();
    BorrowingStatusDTO getBorrowingStatusById(Long id);
    BorrowingStatusDTO saveBorrowingStatus(BorrowingStatusDTO borrowingStatusDTO);
    void deleteBorrowingStatus(Long id);
    List<BorrowingStatusDTO> findBorrowingStatusesByBorrowingId(Long borrowingId);
}
