package com.library.payment.mapper;
import com.library.payment.PaymentMethod;
import com.library.payment.dto.PaymentMethodDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethodMapper INSTANCE = Mappers.getMapper(PaymentMethodMapper.class);

    @Mapping(source = "user.id", target = "userId")
    PaymentMethodDTO toDTO(PaymentMethod paymentMethod);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    PaymentMethod toEntity(PaymentMethodDTO paymentMethodDTO);
}
