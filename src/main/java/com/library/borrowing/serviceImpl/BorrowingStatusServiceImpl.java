package com.library.borrowing.serviceImpl;
import com.library.borrowing.BorrowingStatus;
import com.library.borrowing.dto.BorrowingStatusDTO;
import com.library.borrowing.mapper.BorrowingStatusMapper;
import com.library.borrowing.repository.BorrowingStatusRepository;
import com.library.borrowing.service.BorrowingStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingStatusServiceImpl implements BorrowingStatusService {

    @Autowired
    private BorrowingStatusRepository borrowingStatusRepository;

    @Autowired
    private BorrowingStatusMapper borrowingStatusMapper;

    @Override
    public List<BorrowingStatusDTO> getAllBorrowingStatuses() {
        List<BorrowingStatus> borrowingStatuses = borrowingStatusRepository.findAll();
        return borrowingStatuses.stream()
                .map(borrowingStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingStatusDTO getBorrowingStatusById(Long id) {
        BorrowingStatus borrowingStatus = borrowingStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing status not found with id " + id));
        return borrowingStatusMapper.toDTO(borrowingStatus);
    }

    @Override
    public BorrowingStatusDTO saveBorrowingStatus(BorrowingStatusDTO borrowingStatusDTO) {
        BorrowingStatus borrowingStatus = borrowingStatusMapper.toEntity(borrowingStatusDTO);
        BorrowingStatus savedBorrowingStatus = borrowingStatusRepository.save(borrowingStatus);
        return borrowingStatusMapper.toDTO(savedBorrowingStatus);
    }

    @Override
    public void deleteBorrowingStatus(Long id) {
        if (!borrowingStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrowing status not found with id " + id);
        }
        borrowingStatusRepository.deleteById(id);
    }

    @Override
    public List<BorrowingStatusDTO> findBorrowingStatusesByBorrowingId(Long borrowingId) {
        List<BorrowingStatus> borrowingStatuses = borrowingStatusRepository.findByBorrowingId(borrowingId);
        return borrowingStatuses.stream()
                .map(borrowingStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
