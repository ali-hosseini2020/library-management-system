package com.library.payment.mapper;
import com.library.payment.PaymentStatus;
import com.library.payment.dto.PaymentStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentStatusMapper {
    PaymentStatusMapper INSTANCE = Mappers.getMapper(PaymentStatusMapper.class);

    @Mapping(source = "payment.id", target = "paymentId")
    PaymentStatusDTO toDTO(PaymentStatus paymentStatus);

    @Mapping(target = "payment", ignore = true) // Assume payment is set separately
    PaymentStatus toEntity(PaymentStatusDTO paymentStatusDTO);
}
