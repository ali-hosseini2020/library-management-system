package com.library.reservation.dto;
import com.library.customizedenum.ReservationStatusType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationStatusDTO {
    private Long id;
    private ReservationStatusType status;
    private Long reservationId;
}
