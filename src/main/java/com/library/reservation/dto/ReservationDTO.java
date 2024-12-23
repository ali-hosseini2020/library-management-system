package com.library.reservation.dto;
import com.library.customizedenum.ReservationStatusType;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationDTO {
    private Long id;
    private LocalDateTime reservationDate;
    private LocalDateTime dueDate;
    private ReservationStatusType status;
    private ReservationUserDTO user;
    private List<ReservationItemDTO> items;
}
