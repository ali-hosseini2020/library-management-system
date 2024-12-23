package com.library.reservation.controller;

import com.library.reservation.dto.ReservationDTO;
import com.library.reservation.service.ReservationService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<ReservationDTO> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getReservationById(@PathVariable Long id) {
        try {
            ReservationDTO reservationDTO = reservationService.getReservationById(id);
            return ResponseEntity.ok(reservationDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReservationDTO> saveReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO savedReservationDTO = reservationService.saveReservation(reservationDTO);
        return ResponseEntity.status(201).body(savedReservationDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<ReservationDTO> findReservationsByUserId(@PathVariable Long userId) {
        return reservationService.findReservationsByUserId(userId);
    }

    @GetMapping("/search/status")
    public List<ReservationDTO> findReservationsByStatus(@RequestParam String status) {
        return reservationService.findReservationsByStatus(status);
    }
}
