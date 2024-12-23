package com.library.user.controller;
import com.library.user.dto.UserNotificationDTO;
import com.library.user.service.UserNotificationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user-notifications")
public class UserNotificationController {

    @Autowired
    private UserNotificationService userNotificationService;

    @GetMapping
    public List<UserNotificationDTO> getAllUserNotifications() {
        return userNotificationService.getAllUserNotifications();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserNotificationDTO> getUserNotificationById(@PathVariable Long id) {
        try {
            UserNotificationDTO userNotificationDTO = userNotificationService.getUserNotificationById(id);
            return ResponseEntity.ok(userNotificationDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<UserNotificationDTO> saveUserNotification(@RequestBody UserNotificationDTO userNotificationDTO) {
        UserNotificationDTO savedUserNotificationDTO = userNotificationService.saveUserNotification(userNotificationDTO);
        return ResponseEntity.status(201).body(savedUserNotificationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserNotification(@PathVariable Long id) {
        try {
            userNotificationService.deleteUserNotification(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/unread/{userId}")
    public List<UserNotificationDTO> findUnreadNotificationsByUserId(@PathVariable Long userId) {
        return userNotificationService.findUnreadNotificationsByUserId(userId);
    }

    @GetMapping("/search/read/{userId}")
    public List<UserNotificationDTO> findReadNotificationsByUserId(@PathVariable Long userId) {
        return userNotificationService.findReadNotificationsByUserId(userId);
    }
}
