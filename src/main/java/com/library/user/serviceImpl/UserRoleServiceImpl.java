package com.library.user.serviceImpl;
import com.library.user.UserRole;
import com.library.user.dto.UserRoleDTO;
import com.library.user.mapper.UserRoleMapper;
import com.library.user.repository.UserRoleRepository;
import com.library.user.service.UserRoleService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        List<UserRole> userRoles = userRoleRepository.findAll();
        return userRoles.stream()
                .map(userRoleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDTO getUserRoleById(Long id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User role not found with id " + id));
        return userRoleMapper.toDTO(userRole);
    }

    @Override
    public UserRoleDTO saveUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = userRoleMapper.toEntity(userRoleDTO);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return userRoleMapper.toDTO(savedUserRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        if (!userRoleRepository.existsById(id)) {
            throw new ResourceNotFoundException("User role not found with id " + id);
        }
        userRoleRepository.deleteById(id);
    }

    @Override
    public List<UserRoleDTO> findUserRolesByRole(String role) {
        List<UserRole> userRoles = userRoleRepository.findByRole(role);
        return userRoles.stream()
                .map(userRoleMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleDTO> findUserRolesByUserId(Long userId) {
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);
        return userRoles.stream()
                .map(userRoleMapper::toDTO)
                .collect(Collectors.toList());
    }
}
