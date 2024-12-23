package com.library.user.serviceImpl;
import com.library.user.User;
import com.library.user.dto.UserDTO;
import com.library.user.mapper.UserMapper;
import com.library.user.repository.UserRepository;
import com.library.user.service.UserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + id));
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO saveUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        User savedUser = userRepository.save(user);
        return userMapper.toDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDTO> findUsersByName(String firstName, String lastName) {
        List<User> users = userRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUsersByEmail(String email) {
        List<User> users = userRepository.findByEmailContaining(email);
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> findUsersByRole(String role) {
        List<User> users = userRepository.findByRole(role);
        return users.stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }
}
