package com.library.borrowing.mapper;
import com.library.borrowing.BorrowingItem;
import com.library.borrowing.dto.BorrowingItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowingItemMapper {
    BorrowingItemMapper INSTANCE = Mappers.getMapper(BorrowingItemMapper.class);

    @Mapping(source = "borrowing.id", target = "borrowingId")
    BorrowingItemDTO toDTO(BorrowingItem borrowingItem);

    @Mapping(target = "borrowing", ignore = true) // Assume borrowing is set separately
    BorrowingItem toEntity(BorrowingItemDTO borrowingItemDTO);
}
