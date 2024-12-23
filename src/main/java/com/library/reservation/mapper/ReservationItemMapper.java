package com.library.reservation.mapper;
import com.library.reservation.ReservationItem;
import com.library.reservation.dto.ReservationItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ReservationItemMapper {
    ReservationItemMapper INSTANCE = Mappers.getMapper(ReservationItemMapper.class);

    @Mapping(source = "reservation.id", target = "reservationId")
    ReservationItemDTO toDTO(ReservationItem reservationItem);

    @Mapping(target = "reservation", ignore = true) // Assume reservation is set separately
    ReservationItem toEntity(ReservationItemDTO reservationItemDTO);
}
