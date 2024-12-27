package com.library.borrowing.serviceImpl;
import com.library.borrowing.BorrowingHistory;
import com.library.borrowing.dto.BorrowingHistoryDTO;
import com.library.borrowing.mapper.BorrowingHistoryMapper;
import com.library.borrowing.repository.BorrowingHistoryRepository;
import com.library.borrowing.service.BorrowingHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingHistoryServiceImpl implements BorrowingHistoryService {

    @Autowired
    private BorrowingHistoryRepository borrowingHistoryRepository;

    @Autowired
    private BorrowingHistoryMapper borrowingHistoryMapper;

    @Override
    public List<BorrowingHistoryDTO> getAllBorrowingHistories() {
        List<BorrowingHistory> borrowingHistories = borrowingHistoryRepository.findAll();
        return borrowingHistories.stream()
                .map(borrowingHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingHistoryDTO getBorrowingHistoryById(Long id) {
        BorrowingHistory borrowingHistory = borrowingHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing history not found with id " + id));
        return borrowingHistoryMapper.toDTO(borrowingHistory);
    }

    @Override
    public BorrowingHistoryDTO saveBorrowingHistory(BorrowingHistoryDTO borrowingHistoryDTO) {
        BorrowingHistory borrowingHistory = borrowingHistoryMapper.toEntity(borrowingHistoryDTO);
        BorrowingHistory savedBorrowingHistory = borrowingHistoryRepository.save(borrowingHistory);
        return borrowingHistoryMapper.toDTO(savedBorrowingHistory);
    }

    @Override
    public void deleteBorrowingHistory(Long id) {
        if (!borrowingHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrowing history not found with id " + id);
        }
        borrowingHistoryRepository.deleteById(id);
    }

    @Override
    public List<BorrowingHistoryDTO> findBorrowingHistoriesByBorrowingId(Long borrowingId) {
        List<BorrowingHistory> borrowingHistories = borrowingHistoryRepository.findByBorrowingId(borrowingId);
        return borrowingHistories.stream()
                .map(borrowingHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
