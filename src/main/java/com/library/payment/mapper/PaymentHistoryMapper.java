package com.library.payment.mapper;
import com.library.payment.PaymentHistory;
import com.library.payment.dto.PaymentHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PaymentHistoryMapper {
    PaymentHistoryMapper INSTANCE = Mappers.getMapper(PaymentHistoryMapper.class);

    @Mapping(source = "payment.id", target = "paymentId")
    PaymentHistoryDTO toDTO(PaymentHistory paymentHistory);

    @Mapping(target = "payment", ignore = true) // Assume payment is set separately
    PaymentHistory toEntity(PaymentHistoryDTO paymentHistoryDTO);
}
