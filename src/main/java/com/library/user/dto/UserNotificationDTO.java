package com.library.user.dto;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserNotificationDTO {
    private Long id;
    private String message;
    private LocalDateTime notificationTime;
    private boolean isRead;
    private Long userId;
}
