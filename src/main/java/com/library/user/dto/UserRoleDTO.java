package com.library.user.dto;
import com.library.customizedenum.RoleType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserRoleDTO {
    private Long id;
    private RoleType role;
    private Long userId;
}
