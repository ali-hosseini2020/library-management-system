package com.library.reservation;
import com.library.customizedenum.ReservationStatusType;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime reservationDate;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private ReservationStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private ReservationUser user;

    @OneToMany(mappedBy = "reservation", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReservationItem> items;
}
