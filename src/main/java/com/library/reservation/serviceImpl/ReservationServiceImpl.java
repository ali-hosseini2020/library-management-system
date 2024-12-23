package com.library.reservation.serviceImpl;
import com.library.reservation.Reservation;
import com.library.reservation.dto.ReservationDTO;
import com.library.reservation.mapper.ReservationMapper;
import com.library.reservation.repository.ReservationRepository;
import com.library.reservation.service.ReservationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ReservationMapper reservationMapper;

    @Override
    public List<ReservationDTO> getAllReservations() {
        List<Reservation> reservations = reservationRepository.findAll();
        return reservations.stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id " + id));
        return reservationMapper.toDTO(reservation);
    }

    @Override
    public ReservationDTO saveReservation(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(savedReservation);
    }

    @Override
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation not found with id " + id);
        }
        reservationRepository.deleteById(id);
    }

    @Override
    public List<ReservationDTO> findReservationsByUserId(Long userId) {
        List<Reservation> reservations = reservationRepository.findByUserId(userId);
        return reservations.stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationDTO> findReservationsByStatus(String status) {
        List<Reservation> reservations = reservationRepository.findByStatus(status);
        return reservations.stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }
}
