package com.library.reservation.service;
import com.library.reservation.dto.ReservationUserDTO;
import java.util.List;

public interface ReservationUserService {
    List<ReservationUserDTO> getAllReservationUsers();
    ReservationUserDTO getReservationUserById(Long id);
    ReservationUserDTO saveReservationUser(ReservationUserDTO reservationUserDTO);
    void deleteReservationUser(Long id);
    List<ReservationUserDTO> findReservationUsersByName(String firstName, String lastName);
    List<ReservationUserDTO> findReservationUsersByEmail(String email);
}
