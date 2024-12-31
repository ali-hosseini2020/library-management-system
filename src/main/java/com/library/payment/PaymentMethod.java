package com.library.payment;
import com.library.customizedenum.PaymentMethodType;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "payment_methods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethodType method;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private PaymentUser user;
}
