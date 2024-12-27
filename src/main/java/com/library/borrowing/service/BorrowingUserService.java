package com.library.borrowing.service;
import com.library.borrowing.dto.BorrowingUserDTO;
import java.util.List;

public interface BorrowingUserService {
    List<BorrowingUserDTO> getAllBorrowingUsers();
    BorrowingUserDTO getBorrowingUserById(Long id);
    BorrowingUserDTO saveBorrowingUser(BorrowingUserDTO borrowingUserDTO);
    void deleteBorrowingUser(Long id);
    List<BorrowingUserDTO> findBorrowingUsersByName(String firstName, String lastName);
    List<BorrowingUserDTO> findBorrowingUsersByEmail(String email);
}
