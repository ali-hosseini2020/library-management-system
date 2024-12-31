package com.library.payment.mapper;
import com.library.payment.PaymentUser;
import com.library.payment.dto.PaymentUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentUserMapper {
    PaymentUserMapper INSTANCE = Mappers.getMapper(PaymentUserMapper.class);

    @Mapping(source = "payments", target = "payments")
    @Mapping(source = "paymentMethods", target = "paymentMethods")
    PaymentUserDTO toDTO(PaymentUser paymentUser);

    @Mapping(target = "payments", ignore = true) // Assume payments are set separately
    @Mapping(target = "paymentMethods", ignore = true) // Assume paymentMethods are set separately
    PaymentUser toEntity(PaymentUserDTO paymentUserDTO);
}
