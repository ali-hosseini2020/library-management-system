package com.library.payment;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "payment_status")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentStatusType status;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
