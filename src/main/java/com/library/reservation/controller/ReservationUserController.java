package com.library.reservation.controller;

import com.library.reservation.dto.ReservationUserDTO;
import com.library.reservation.service.ReservationUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation-users")
public class ReservationUserController {

    @Autowired
    private ReservationUserService reservationUserService;

    @GetMapping
    public List<ReservationUserDTO> getAllReservationUsers() {
        return reservationUserService.getAllReservationUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservationUserDTO> getReservationUserById(@PathVariable Long id) {
        try {
            ReservationUserDTO reservationUserDTO = reservationUserService.getReservationUserById(id);
            return ResponseEntity.ok(reservationUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReservationUserDTO> saveReservationUser(@RequestBody ReservationUserDTO reservationUserDTO) {
        ReservationUserDTO savedReservationUserDTO = reservationUserService.saveReservationUser(reservationUserDTO);
        return ResponseEntity.status(201).body(savedReservationUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservationUser(@PathVariable Long id) {
        try {
            reservationUserService.deleteReservationUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<ReservationUserDTO> findReservationUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return reservationUserService.findReservationUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<ReservationUserDTO> findReservationUsersByEmail(@RequestParam String email) {
        return reservationUserService.findReservationUsersByEmail(email);
    }
}
