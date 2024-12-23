package com.library.user.mapper;
import com.library.user.UserNotification;
import com.library.user.dto.UserNotificationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserNotificationMapper {
    UserNotificationMapper INSTANCE = Mappers.getMapper(UserNotificationMapper.class);

    @Mapping(source = "user.id", target = "userId")
    UserNotificationDTO toDTO(UserNotification userNotification);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    UserNotification toEntity(UserNotificationDTO userNotificationDTO);
}
