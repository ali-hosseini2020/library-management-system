package com.library.reservation.service;
import com.library.reservation.dto.ReservationDTO;
import java.util.List;

public interface ReservationService {
    List<ReservationDTO> getAllReservations();
    ReservationDTO getReservationById(Long id);
    ReservationDTO saveReservation(ReservationDTO reservationDTO);
    void deleteReservation(Long id);
    List<ReservationDTO> findReservationsByUserId(Long userId);
    List<ReservationDTO> findReservationsByStatus(String status);
}
