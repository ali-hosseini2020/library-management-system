package com.library.payment;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "payment_history")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    private LocalDateTime actionDate;

    @Enumerated(EnumType.STRING)
    private PaymentStatusType status;

    private String notes;
}
