package com.library.user.service;
import com.library.user.dto.UserDTO;
import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO saveUser(UserDTO userDTO);
    void deleteUser(Long id);
    List<UserDTO> findUsersByName(String firstName, String lastName);
    List<UserDTO> findUsersByEmail(String email);
    List<UserDTO> findUsersByRole(String role);
}
