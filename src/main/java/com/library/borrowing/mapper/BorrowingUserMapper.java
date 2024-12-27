
package com.library.borrowing.mapper;
import com.library.borrowing.BorrowingUser;
import com.library.borrowing.dto.BorrowingUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface BorrowingUserMapper {
    BorrowingUserMapper INSTANCE = Mappers.getMapper(BorrowingUserMapper.class);

    @Mapping(source = "borrowings", target = "borrowings")
    BorrowingUserDTO toDTO(BorrowingUser borrowingUser);

    @Mapping(target = "borrowings", ignore = true) // Assume borrowings are set separately
    BorrowingUser toEntity(BorrowingUserDTO borrowingUserDTO);
}
