package com.library.user.mapper;
import com.library.user.User;
import com.library.user.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "userAccount", target = "userAccount")
    @Mapping(source = "notifications", target = "notifications")
    UserDTO toDTO(User user);

    @Mapping(target = "userAccount", ignore = true) // Assume userAccount is set separately
    @Mapping(target = "notifications", ignore = true) // Assume notifications are set separately
    User toEntity(UserDTO userDTO);
}
