package com.library.user.service;
import com.library.user.dto.UserNotificationDTO;
import java.util.List;

public interface UserNotificationService {
    List<UserNotificationDTO> getAllUserNotifications();
    UserNotificationDTO getUserNotificationById(Long id);
    UserNotificationDTO saveUserNotification(UserNotificationDTO userNotificationDTO);
    void deleteUserNotification(Long id);
    List<UserNotificationDTO> findUnreadNotificationsByUserId(Long userId);
    List<UserNotificationDTO> findReadNotificationsByUserId(Long userId);
}
