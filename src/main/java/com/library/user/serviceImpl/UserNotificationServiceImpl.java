package com.library.user.serviceImpl;
import com.library.user.UserNotification;
import com.library.user.dto.UserNotificationDTO;
import com.library.user.mapper.UserNotificationMapper;
import com.library.user.repository.UserNotificationRepository;
import com.library.user.service.UserNotificationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {

    @Autowired
    private UserNotificationRepository userNotificationRepository;

    @Autowired
    private UserNotificationMapper userNotificationMapper;

    @Override
    public List<UserNotificationDTO> getAllUserNotifications() {
        List<UserNotification> userNotifications = userNotificationRepository.findAll();
        return userNotifications.stream()
                .map(userNotificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserNotificationDTO getUserNotificationById(Long id) {
        UserNotification userNotification = userNotificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User notification not found with id " + id));
        return userNotificationMapper.toDTO(userNotification);
    }

    @Override
    public UserNotificationDTO saveUserNotification(UserNotificationDTO userNotificationDTO) {
        UserNotification userNotification = userNotificationMapper.toEntity(userNotificationDTO);
        UserNotification savedUserNotification = userNotificationRepository.save(userNotification);
        return userNotificationMapper.toDTO(savedUserNotification);
    }

    @Override
    public void deleteUserNotification(Long id) {
        if (!userNotificationRepository.existsById(id)) {
            throw new ResourceNotFoundException("User notification not found with id " + id);
        }
        userNotificationRepository.deleteById(id);
    }

    @Override
    public List<UserNotificationDTO> findUnreadNotificationsByUserId(Long userId) {
        List<UserNotification> userNotifications = userNotificationRepository.findUnreadNotificationsByUserId(userId);
        return userNotifications.stream()
                .map(userNotificationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserNotificationDTO> findReadNotificationsByUserId(Long userId) {
        List<UserNotification> userNotifications = userNotificationRepository.findReadNotificationsByUserId(userId);
        return userNotifications.stream()
                .map(userNotificationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
