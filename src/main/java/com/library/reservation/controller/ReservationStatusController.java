package com.library.reservation.controller;

import com.library.reservation.dto.ReservationStatusDTO;
import com.library.reservation.service.ReservationStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation-statuses")
public class ReservationStatusController {

    @Autowired
    private ReservationStatusService reservationStatusService;

    @GetMapping
    public List<ReservationStatusDTO> getAllReservationStatuses() {
        return reservationStatusService.getAllReservationStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationStatusDTO> getReservationStatusById(@PathVariable Long id) {
        try {
            ReservationStatusDTO reservationStatusDTO = reservationStatusService.getReservationStatusById(id);
            return ResponseEntity.ok(reservationStatusDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReservationStatusDTO> saveReservationStatus(@RequestBody ReservationStatusDTO reservationStatusDTO) {
        ReservationStatusDTO savedReservationStatusDTO = reservationStatusService.saveReservationStatus(reservationStatusDTO);
        return ResponseEntity.status(201).body(savedReservationStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationStatus(@PathVariable Long id) {
        try {
            reservationStatusService.deleteReservationStatus(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/reservation/{reservationId}")
    public List<ReservationStatusDTO> findReservationStatusesByReservationId(@PathVariable Long reservationId) {
        return reservationStatusService.findReservationStatusesByReservationId(reservationId);
    }
}
