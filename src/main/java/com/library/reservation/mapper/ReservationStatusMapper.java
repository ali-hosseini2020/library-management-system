package com.library.reservation.mapper;

import com.library.reservation.ReservationStatus;
import com.library.reservation.dto.ReservationStatusDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationStatusMapper {
    ReservationStatusMapper INSTANCE = Mappers.getMapper(ReservationStatusMapper.class);

    @Mapping(source = "reservation.id", target = "reservationId")
    ReservationStatusDTO toDTO(ReservationStatus reservationStatus);

    @Mapping(target = "reservation", ignore = true) // Assume reservation is set separately
    ReservationStatus toEntity(ReservationStatusDTO reservationStatusDTO);
}
