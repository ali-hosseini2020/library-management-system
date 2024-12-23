package com.library.user.serviceImpl;
import com.library.user.UserAccount;
import com.library.user.dto.UserAccountDTO;
import com.library.user.mapper.UserAccountMapper;
import com.library.user.repository.UserAccountRepository;
import com.library.user.service.UserAccountService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountRepository userAccountRepository;

    @Autowired
    private UserAccountMapper userAccountMapper;

    @Override
    public List<UserAccountDTO> getAllUserAccounts() {
        List<UserAccount> userAccounts = userAccountRepository.findAll();
        return userAccounts.stream()
                .map(userAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserAccountDTO getUserAccountById(Long id) {
        UserAccount userAccount = userAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User account not found with id " + id));
        return userAccountMapper.toDTO(userAccount);
    }

    @Override
    public UserAccountDTO saveUserAccount(UserAccountDTO userAccountDTO) {
        UserAccount userAccount = userAccountMapper.toEntity(userAccountDTO);
        UserAccount savedUserAccount = userAccountRepository.save(userAccount);
        return userAccountMapper.toDTO(savedUserAccount);
    }

    @Override
    public void deleteUserAccount(Long id) {
        if (!userAccountRepository.existsById(id)) {
            throw new ResourceNotFoundException("User account not found with id " + id);
        }
        userAccountRepository.deleteById(id);
    }

    @Override
    public List<UserAccountDTO> findUserAccountsByUsername(String username) {
        List<UserAccount> userAccounts = userAccountRepository.findByUsernameContaining(username);
        return userAccounts.stream()
                .map(userAccountMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserAccountDTO> findUserAccountsByUserId(Long userId) {
        List<UserAccount> userAccounts = userAccountRepository.findByUserId(userId);
        return userAccounts.stream()
                .map(userAccountMapper::toDTO)
                .collect(Collectors.toList());
    }
}
