package com.library.user.mapper;
import com.library.user.UserRole;
import com.library.user.dto.UserRoleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserRoleMapper {
    UserRoleMapper INSTANCE = Mappers.getMapper(UserRoleMapper.class);

    @Mapping(source = "user.id", target = "userId")
    UserRoleDTO toDTO(UserRole userRole);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    UserRole toEntity(UserRoleDTO userRoleDTO);
}
