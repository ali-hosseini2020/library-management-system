package com.library.user.service;

import com.library.user.dto.UserAccountDTO;

import java.util.List;

public interface UserAccountService {
    List<UserAccountDTO> getAllUserAccounts();
    UserAccountDTO getUserAccountById(Long id);
    UserAccountDTO saveUserAccount(UserAccountDTO userAccountDTO);
    void deleteUserAccount(Long id);
    List<UserAccountDTO> findUserAccountsByUsername(String username);
    List<UserAccountDTO> findUserAccountsByUserId(Long userId);
}
