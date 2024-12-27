package com.library.borrowing.mapper;
import com.library.borrowing.BorrowingHistory;
import com.library.borrowing.dto.BorrowingHistoryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowingHistoryMapper {
    BorrowingHistoryMapper INSTANCE = Mappers.getMapper(BorrowingHistoryMapper.class);

    @Mapping(source = "borrowing.id", target = "borrowingId")
    BorrowingHistoryDTO toDTO(BorrowingHistory borrowingHistory);

    @Mapping(target = "borrowing", ignore = true) // Assume borrowing is set separately
    BorrowingHistory toEntity(BorrowingHistoryDTO borrowingHistoryDTO);
}
