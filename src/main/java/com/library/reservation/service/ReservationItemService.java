package com.library.reservation.service;
import com.library.reservation.dto.ReservationItemDTO;
import java.util.List;

public interface ReservationItemService {
    List<ReservationItemDTO> getAllReservationItems();
    ReservationItemDTO getReservationItemById(Long id);
    ReservationItemDTO saveReservationItem(ReservationItemDTO reservationItemDTO);
    void deleteReservationItem(Long id);
    List<ReservationItemDTO> findReservationItemsByReservationId(Long reservationId);
}

