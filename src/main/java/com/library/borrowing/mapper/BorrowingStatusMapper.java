package com.library.borrowing.mapper;
import com.library.borrowing.BorrowingStatus;
import com.library.borrowing.dto.BorrowingStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowingStatusMapper {
    BorrowingStatusMapper INSTANCE = Mappers.getMapper(BorrowingStatusMapper.class);

    @Mapping(source = "borrowing.id", target = "borrowingId")
    BorrowingStatusDTO toDTO(BorrowingStatus borrowingStatus);

    @Mapping(target = "borrowing", ignore = true) // Assume borrowing is set separately
    BorrowingStatus toEntity(BorrowingStatusDTO borrowingStatusDTO);
}
