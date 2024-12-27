package com.library.borrowing.service;
import com.library.borrowing.dto.BorrowingDTO;
import java.util.List;

public interface BorrowingService {
    List<BorrowingDTO> getAllBorrowings();
    BorrowingDTO getBorrowingById(Long id);
    BorrowingDTO saveBorrowing(BorrowingDTO borrowingDTO);
    void deleteBorrowing(Long id);
    List<BorrowingDTO> findBorrowingsByUserId(Long userId);
    List<BorrowingDTO> findBorrowingsByStatus(String status);
}
