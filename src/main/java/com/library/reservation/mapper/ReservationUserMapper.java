package com.library.reservation.mapper;

import com.library.reservation.ReservationUser;
import com.library.reservation.dto.ReservationUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationUserMapper {
    ReservationUserMapper INSTANCE = Mappers.getMapper(ReservationUserMapper.class);

    @Mapping(source = "reservations", target = "reservations")
    ReservationUserDTO toDTO(ReservationUser reservationUser);

    @Mapping(target = "reservations", ignore = true) // Assume reservations are set separately
    ReservationUser toEntity(ReservationUserDTO reservationUserDTO);
}
