package com.library.borrowing.service;
import com.library.borrowing.dto.BorrowingItemDTO;
import java.util.List;

public interface BorrowingItemService {
    List<BorrowingItemDTO> getAllBorrowingItems();
    BorrowingItemDTO getBorrowingItemById(Long id);
    BorrowingItemDTO saveBorrowingItem(BorrowingItemDTO borrowingItemDTO);
    void deleteBorrowingItem(Long id);
    List<BorrowingItemDTO> findBorrowingItemsByBorrowingId(Long borrowingId);
}
