package com.library.borrowing.serviceImpl;
import com.library.borrowing.BorrowingUser;
import com.library.borrowing.dto.BorrowingUserDTO;
import com.library.borrowing.mapper.BorrowingUserMapper;
import com.library.borrowing.repository.BorrowingUserRepository;
import com.library.borrowing.service.BorrowingUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BorrowingUserServiceImpl implements BorrowingUserService {

    @Autowired
    private BorrowingUserRepository borrowingUserRepository;

    @Autowired
    private BorrowingUserMapper borrowingUserMapper;

    @Override
    public List<BorrowingUserDTO> getAllBorrowingUsers() {
        List<BorrowingUser> borrowingUsers = borrowingUserRepository.findAll();
        return borrowingUsers.stream()
                .map(borrowingUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BorrowingUserDTO getBorrowingUserById(Long id) {
        BorrowingUser borrowingUser = borrowingUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Borrowing user not found with id " + id));
        return borrowingUserMapper.toDTO(borrowingUser);
    }

    @Override
    public BorrowingUserDTO saveBorrowingUser(BorrowingUserDTO borrowingUserDTO) {
        BorrowingUser borrowingUser = borrowingUserMapper.toEntity(borrowingUserDTO);
        BorrowingUser savedBorrowingUser = borrowingUserRepository.save(borrowingUser);
        return borrowingUserMapper.toDTO(savedBorrowingUser);
    }

    @Override
    public void deleteBorrowingUser(Long id) {
        if (!borrowingUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Borrowing user not found with id " + id);
        }
        borrowingUserRepository.deleteById(id);
    }

    @Override
    public List<BorrowingUserDTO> findBorrowingUsersByName(String firstName, String lastName) {
        List<BorrowingUser> borrowingUsers = borrowingUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return borrowingUsers.stream()
                .map(borrowingUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BorrowingUserDTO> findBorrowingUsersByEmail(String email) {
        List<BorrowingUser> borrowingUsers = borrowingUserRepository.findByEmailContaining(email);
        return borrowingUsers.stream()
                .map(borrowingUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
