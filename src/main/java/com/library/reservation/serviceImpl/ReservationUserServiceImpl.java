package com.library.reservation.serviceImpl;
import com.library.reservation.ReservationUser;
import com.library.reservation.dto.ReservationUserDTO;
import com.library.reservation.mapper.ReservationUserMapper;
import com.library.reservation.repository.ReservationUserRepository;
import com.library.reservation.service.ReservationUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationUserServiceImpl implements ReservationUserService {

    @Autowired
    private ReservationUserRepository reservationUserRepository;

    @Autowired
    private ReservationUserMapper reservationUserMapper;

    @Override
    public List<ReservationUserDTO> getAllReservationUsers() {
        List<ReservationUser> reservationUsers = reservationUserRepository.findAll();
        return reservationUsers.stream()
                .map(reservationUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationUserDTO getReservationUserById(Long id) {
        ReservationUser reservationUser = reservationUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation user not found with id " + id));
        return reservationUserMapper.toDTO(reservationUser);
    }

    @Override
    public ReservationUserDTO saveReservationUser(ReservationUserDTO reservationUserDTO) {
        ReservationUser reservationUser = reservationUserMapper.toEntity(reservationUserDTO);
        ReservationUser savedReservationUser = reservationUserRepository.save(reservationUser);
        return reservationUserMapper.toDTO(savedReservationUser);
    }

    @Override
    public void deleteReservationUser(Long id) {
        if (!reservationUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reservation user not found with id " + id);
        }
        reservationUserRepository.deleteById(id);
    }

    @Override
    public List<ReservationUserDTO> findReservationUsersByName(String firstName, String lastName) {
        List<ReservationUser> reservationUsers = reservationUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return reservationUsers.stream()
                .map(reservationUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservationUserDTO> findReservationUsersByEmail(String email) {
        List<ReservationUser> reservationUsers = reservationUserRepository.findByEmailContaining(email);
        return reservationUsers.stream()
                .map(reservationUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
