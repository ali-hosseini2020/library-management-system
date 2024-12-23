package com.library.user.controller;
import com.library.user.dto.UserRoleDTO;
import com.library.user.service.UserRoleService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-roles")
public class UserRoleController {

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public List<UserRoleDTO> getAllUserRoles() {
        return userRoleService.getAllUserRoles();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRoleDTO> getUserRoleById(@PathVariable Long id) {
        try {
            UserRoleDTO userRoleDTO = userRoleService.getUserRoleById(id);
            return ResponseEntity.ok(userRoleDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserRoleDTO> saveUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO savedUserRoleDTO = userRoleService.saveUserRole(userRoleDTO);
        return ResponseEntity.status(201).body(savedUserRoleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long id) {
        try {
            userRoleService.deleteUserRole(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/role")
    public List<UserRoleDTO> findUserRolesByRole(@RequestParam String role) {
        return userRoleService.findUserRolesByRole(role);
    }

    @GetMapping("/search/user/{userId}")
    public List<UserRoleDTO> findUserRolesByUserId(@PathVariable Long userId) {
        return userRoleService.findUserRolesByUserId(userId);
    }
}
