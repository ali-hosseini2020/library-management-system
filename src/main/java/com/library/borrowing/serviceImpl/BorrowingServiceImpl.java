package com.library.borrowing.serviceImpl;
import com.library.borrowing.Borrowing;
import com.library.borrowing.dto.BorrowingDTO;
import com.library.borrowing.mapper.BorrowingMapper;
import com.library.borrowing.repository.BorrowingRepository;
import com.library.borrowing.service.BorrowingService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingServiceImpl implements BorrowingService {

    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BorrowingMapper borrowingMapper;

    @Override
    public List<BorrowingDTO> getAllBorrowings() {
        List<Borrowing> borrowings = borrowingRepository.findAll();
        return borrowings.stream()
                .map(borrowingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingDTO getBorrowingById(Long id) {
        Borrowing borrowing = borrowingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing not found with id " + id));
        return borrowingMapper.toDTO(borrowing);
    }

    @Override
    public BorrowingDTO saveBorrowing(BorrowingDTO borrowingDTO) {
        Borrowing borrowing = borrowingMapper.toEntity(borrowingDTO);
        Borrowing savedBorrowing = borrowingRepository.save(borrowing);
        return borrowingMapper.toDTO(savedBorrowing);
    }

    @Override
    public void deleteBorrowing(Long id) {
        if (!borrowingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrowing not found with id " + id);
        }
        borrowingRepository.deleteById(id);
    }

    @Override
    public List<BorrowingDTO> findBorrowingsByUserId(Long userId) {
        List<Borrowing> borrowings = borrowingRepository.findByUserId(userId);
        return borrowings.stream()
                .map(borrowingMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BorrowingDTO> findBorrowingsByStatus(String status) {
        List<Borrowing> borrowings = borrowingRepository.findByStatus(status);
        return borrowings.stream()
                .map(borrowingMapper::toDTO)
                .collect(Collectors.toList());
    }
}
