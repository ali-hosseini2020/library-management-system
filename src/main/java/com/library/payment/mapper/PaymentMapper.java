package com.library.payment.mapper;
import com.library.payment.Payment;
import com.library.payment.dto.PaymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "history", target = "history")
    PaymentDTO toDTO(Payment payment);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    @Mapping(target = "history", ignore = true) // Assume history is set separately
    Payment toEntity(PaymentDTO paymentDTO);
}
