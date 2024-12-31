package com.library.payment.dto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class PaymentUserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private List<PaymentDTO> payments;
    private List<PaymentMethodDTO> paymentMethods;
}

