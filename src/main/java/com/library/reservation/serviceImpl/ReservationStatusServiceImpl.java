package com.library.reservation.serviceImpl;
import com.library.reservation.ReservationStatus;
import com.library.reservation.dto.ReservationStatusDTO;
import com.library.reservation.mapper.ReservationStatusMapper;
import com.library.reservation.repository.ReservationStatusRepository;
import com.library.reservation.service.ReservationStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationStatusServiceImpl implements ReservationStatusService {

    @Autowired
    private ReservationStatusRepository reservationStatusRepository;

    @Autowired
    private ReservationStatusMapper reservationStatusMapper;

    @Override
    public List<ReservationStatusDTO> getAllReservationStatuses() {
        List<ReservationStatus> reservationStatuses = reservationStatusRepository.findAll();
        return reservationStatuses.stream()
                .map(reservationStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationStatusDTO getReservationStatusById(Long id) {
        ReservationStatus reservationStatus = reservationStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation status not found with id " + id));
        return reservationStatusMapper.toDTO(reservationStatus);
    }

    @Override
    public ReservationStatusDTO saveReservationStatus(ReservationStatusDTO reservationStatusDTO) {
        ReservationStatus reservationStatus = reservationStatusMapper.toEntity(reservationStatusDTO);
        ReservationStatus savedReservationStatus = reservationStatusRepository.save(reservationStatus);
        return reservationStatusMapper.toDTO(savedReservationStatus);
    }

    @Override
    public void deleteReservationStatus(Long id) {
        if (!reservationStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation status not found with id " + id);
        }
        reservationStatusRepository.deleteById(id);
    }

    @Override
    public List<ReservationStatusDTO> findReservationStatusesByReservationId(Long reservationId) {
        List<ReservationStatus> reservationStatuses = reservationStatusRepository.findByReservationId(reservationId);
        return reservationStatuses.stream()
                .map(reservationStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
