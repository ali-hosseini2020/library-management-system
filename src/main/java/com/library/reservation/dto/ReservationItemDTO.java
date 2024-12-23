package com.library.reservation.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;
    private Long reservationId;
}
