package com.library.user.service;
import com.library.user.dto.UserRoleDTO;
import java.util.List;

public interface UserRoleService {
    List<UserRoleDTO> getAllUserRoles();
    UserRoleDTO getUserRoleById(Long id);
    UserRoleDTO saveUserRole(UserRoleDTO userRoleDTO);
    void deleteUserRole(Long id);
    List<UserRoleDTO> findUserRolesByRole(String role);
    List<UserRoleDTO> findUserRolesByUserId(Long userId);
}
