package com.library.reservation.service;
import com.library.reservation.dto.ReservationStatusDTO;
import java.util.List;

public interface ReservationStatusService {
    List<ReservationStatusDTO> getAllReservationStatuses();
    ReservationStatusDTO getReservationStatusById(Long id);
    ReservationStatusDTO saveReservationStatus(ReservationStatusDTO reservationStatusDTO);
    void deleteReservationStatus(Long id);
    List<ReservationStatusDTO> findReservationStatusesByReservationId(Long reservationId);
}
