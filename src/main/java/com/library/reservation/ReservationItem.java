package com.library.reservation;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "reservation_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReservationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String itemName;
    private String itemDescription;

    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;
}
