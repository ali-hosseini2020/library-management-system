package com.library.user.mapper;
import com.library.user.UserAccount;
import com.library.user.dto.UserAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

    @Mapping(source = "user.id", target = "userId")
    UserAccountDTO toDTO(UserAccount userAccount);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    UserAccount toEntity(UserAccountDTO userAccountDTO);
}
