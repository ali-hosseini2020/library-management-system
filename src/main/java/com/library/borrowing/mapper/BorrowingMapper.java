package com.library.borrowing.mapper;
import com.library.borrowing.Borrowing;
import com.library.borrowing.dto.BorrowingDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowingMapper {
    BorrowingMapper INSTANCE = Mappers.getMapper(BorrowingMapper.class);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "items", target = "items")
    @Mapping(source = "history", target = "history")
    BorrowingDTO toDTO(Borrowing borrowing);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    @Mapping(target = "items", ignore = true) // Assume items are set separately
    @Mapping(target = "history", ignore = true) // Assume history is set separately
    Borrowing toEntity(BorrowingDTO borrowingDTO);
}
