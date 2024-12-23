package com.library.user.controller;
import com.library.user.dto.UserDTO;
import com.library.user.service.UserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        try {
            UserDTO userDTO = userService.getUserById(id);
            return ResponseEntity.ok(userDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO) {
        UserDTO savedUserDTO = userService.saveUser(userDTO);
        return ResponseEntity.status(201).body(savedUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        try {
            userService.deleteUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<UserDTO> findUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return userService.findUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<UserDTO> findUsersByEmail(@RequestParam String email) {
        return userService.findUsersByEmail(email);
    }

    @GetMapping("/search/role")
    public List<UserDTO> findUsersByRole(@RequestParam String role) {
        return userService.findUsersByRole(role);
    }
}
