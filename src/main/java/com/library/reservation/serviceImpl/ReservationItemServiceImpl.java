package com.library.reservation.serviceImpl;
import com.library.reservation.ReservationItem;
import com.library.reservation.dto.ReservationItemDTO;
import com.library.reservation.mapper.ReservationItemMapper;
import com.library.reservation.repository.ReservationItemRepository;
import com.library.reservation.service.ReservationItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationItemServiceImpl implements ReservationItemService {

    @Autowired
    private ReservationItemRepository reservationItemRepository;

    @Autowired
    private ReservationItemMapper reservationItemMapper;

    @Override
    public List<ReservationItemDTO> getAllReservationItems() {
        List<ReservationItem> reservationItems = reservationItemRepository.findAll();
        return reservationItems.stream()
                .map(reservationItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationItemDTO getReservationItemById(Long id) {
        ReservationItem reservationItem = reservationItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation item not found with id " + id));
        return reservationItemMapper.toDTO(reservationItem);
    }

    @Override
    public ReservationItemDTO saveReservationItem(ReservationItemDTO reservationItemDTO) {
        ReservationItem reservationItem = reservationItemMapper.toEntity(reservationItemDTO);
        ReservationItem savedReservationItem = reservationItemRepository.save(reservationItem);
        return reservationItemMapper.toDTO(savedReservationItem);
    }

    @Override
    public void deleteReservationItem(Long id) {
        if (!reservationItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation item not found with id " + id);
        }
        reservationItemRepository.deleteById(id);
    }

    @Override
    public List<ReservationItemDTO> findReservationItemsByReservationId(Long reservationId) {
        List<ReservationItem> reservationItems = reservationItemRepository.findByReservationId(reservationId);
        return reservationItems.stream()
                .map(reservationItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
