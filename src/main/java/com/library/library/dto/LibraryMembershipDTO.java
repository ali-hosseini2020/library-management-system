package com.library.library.dto;
import lombok.*;
import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LibraryMembershipDTO {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean active;
    private Long userId;
}
