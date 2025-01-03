package com.library.payment.dto;
import com.library.customizedenum.PaymentStatusType;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentDTO {
    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private PaymentStatusType status;
    private PaymentUserDTO user;
    private List<PaymentHistoryDTO> history;
}
