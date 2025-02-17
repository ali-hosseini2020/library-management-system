package com.library.payment;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime paymentDate;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private PaymentStatusType status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PaymentUser user;

    @OneToMany(mappedBy = "payment", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PaymentHistory> history;
}

