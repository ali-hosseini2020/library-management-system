package com.library.borrowing.serviceImpl;
import com.library.borrowing.BorrowingItem;
import com.library.borrowing.dto.BorrowingItemDTO;
import com.library.borrowing.mapper.BorrowingItemMapper;
import com.library.borrowing.repository.BorrowingItemRepository;
import com.library.borrowing.service.BorrowingItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingItemServiceImpl implements BorrowingItemService {

    @Autowired
    private BorrowingItemRepository borrowingItemRepository;

    @Autowired
    private BorrowingItemMapper borrowingItemMapper;

    @Override
    public List<BorrowingItemDTO> getAllBorrowingItems() {
        List<BorrowingItem> borrowingItems = borrowingItemRepository.findAll();
        return borrowingItems.stream()
                .map(borrowingItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingItemDTO getBorrowingItemById(Long id) {
        BorrowingItem borrowingItem = borrowingItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing item not found with id " + id));
        return borrowingItemMapper.toDTO(borrowingItem);
    }

    @Override
    public BorrowingItemDTO saveBorrowingItem(BorrowingItemDTO borrowingItemDTO) {
        BorrowingItem borrowingItem = borrowingItemMapper.toEntity(borrowingItemDTO);
        BorrowingItem savedBorrowingItem = borrowingItemRepository.save(borrowingItem);
        return borrowingItemMapper.toDTO(savedBorrowingItem);
    }

    @Override
    public void deleteBorrowingItem(Long id) {
        if (!borrowingItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrowing item not found with id " + id);
        }
        borrowingItemRepository.deleteById(id);
    }

    @Override
    public List<BorrowingItemDTO> findBorrowingItemsByBorrowingId(Long borrowingId) {
        List<BorrowingItem> borrowingItems = borrowingItemRepository.findByBorrowingId(borrowingId);
        return borrowingItems.stream()
                .map(borrowingItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
