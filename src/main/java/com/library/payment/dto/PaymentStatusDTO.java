package com.library.payment.dto;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentStatusDTO {
    private Long id;
    private PaymentStatusType status;
    private Long paymentId;
}
