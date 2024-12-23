package com.library.reservation.repository;
import com.library.reservation.ReservationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationStatusRepository extends JpaRepository<ReservationStatus, Long> {

    @Query("SELECT rs FROM ReservationStatus rs WHERE rs.reservation.id = :reservationId")
    List<ReservationStatus> findByReservationId(@Param("reservationId") Long reservationId);
}
