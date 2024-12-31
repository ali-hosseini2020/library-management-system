package com.library.fine.serviceImpl;
import com.library.fine.FineUser;
import com.library.fine.dto.FineUserDTO;
import com.library.fine.mapper.FineUserMapper;
import com.library.fine.repository.FineUserRepository;
import com.library.fine.service.FineUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FineUserServiceImpl implements FineUserService {

    @Autowired
    private FineUserRepository fineUserRepository;

    @Autowired
    private FineUserMapper fineUserMapper;

    @Override
    public List<FineUserDTO> getAllFineUsers() {
        List<FineUser> fineUsers = fineUserRepository.findAll();
        return fineUsers.stream()
                .map(fineUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public FineUserDTO getFineUserById(Long id) {
        FineUser fineUser = fineUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fine user not found with id " + id));
        return fineUserMapper.toDTO(fineUser);
    }

    @Override
    public FineUserDTO saveFineUser(FineUserDTO fineUserDTO) {
        FineUser fineUser = fineUserMapper.toEntity(fineUserDTO);
        FineUser savedFineUser = fineUserRepository.save(fineUser);
        return fineUserMapper.toDTO(savedFineUser);
    }

    @Override
    public void deleteFineUser(Long id) {
        if (!fineUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Fine user not found with id " + id);
        }
        fineUserRepository.deleteById(id);
    }

    @Override
    public List<FineUserDTO> findFineUsersByName(String firstName, String lastName) {
        List<FineUser> fineUsers = fineUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return fineUsers.stream()
                .map(fineUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<FineUserDTO> findFineUsersByEmail(String email) {
        List<FineUser> fineUsers = fineUserRepository.findByEmailContaining(email);
        return fineUsers.stream()
                .map(fineUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
