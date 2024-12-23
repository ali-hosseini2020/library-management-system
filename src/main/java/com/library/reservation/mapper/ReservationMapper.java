package com.library.reservation.mapper;

import com.library.reservation.Reservation;
import com.library.reservation.dto.ReservationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationMapper {
    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "items", target = "items")
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(target = "user", ignore = true) // Assume user is set separately
    @Mapping(target = "items", ignore = true) // Assume items are set separately
    Reservation toEntity(ReservationDTO reservationDTO);
}
