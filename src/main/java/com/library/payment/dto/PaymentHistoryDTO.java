package com.library.payment.dto;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentHistoryDTO {
    private Long id;
    private Long paymentId;
    private LocalDateTime actionDate;
    private PaymentStatusType status;
    private String notes;
}
