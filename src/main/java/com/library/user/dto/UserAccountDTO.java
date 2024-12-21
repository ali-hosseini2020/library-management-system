package com.library.user.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class UserAccountDTO {
    private Long id;
    private String username;
    private String password;
    private Long userId;
}
