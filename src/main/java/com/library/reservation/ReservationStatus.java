package com.library.reservation;
import com.library.customizedenum.ReservationStatusType;
import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "reservation_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ReservationStatusType status;

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
