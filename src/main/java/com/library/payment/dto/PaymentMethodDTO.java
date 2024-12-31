package com.library.payment.dto;
import com.library.customizedenum.PaymentMethodType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentMethodDTO {
    private Long id;
    private PaymentMethodType method;
    private Long userId;
}
