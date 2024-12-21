package com.library.user.dto;
import com.library.customizedenum.RoleType;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private RoleType role;
    private UserAccountDTO userAccount;
    private List<UserNotificationDTO> notifications;
}
