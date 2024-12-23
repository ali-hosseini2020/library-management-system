package com.library.reservation.controller;

import com.library.reservation.dto.ReservationItemDTO;
import com.library.reservation.service.ReservationItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation-items")
public class ReservationItemController {

    @Autowired
    private ReservationItemService reservationItemService;

    @GetMapping
    public List<ReservationItemDTO> getAllReservationItems() {
        return reservationItemService.getAllReservationItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationItemDTO> getReservationItemById(@PathVariable Long id) {
        try {
            ReservationItemDTO reservationItemDTO = reservationItemService.getReservationItemById(id);
            return ResponseEntity.ok(reservationItemDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReservationItemDTO> saveReservationItem(@RequestBody ReservationItemDTO reservationItemDTO) {
        ReservationItemDTO savedReservationItemDTO = reservationItemService.saveReservationItem(reservationItemDTO);
        return ResponseEntity.status(201).body(savedReservationItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationItem(@PathVariable Long id) {
        try {
            reservationItemService.deleteReservationItem(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/reservation/{reservationId}")
    public List<ReservationItemDTO> findReservationItemsByReservationId(@PathVariable Long reservationId) {
        return reservationItemService.findReservationItemsByReservationId(reservationId);
    }
}
