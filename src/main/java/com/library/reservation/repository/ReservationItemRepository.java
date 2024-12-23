package com.library.reservation.repository;
import com.library.reservation.ReservationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

    @Query("SELECT ri FROM ReservationItem ri WHERE ri.reservation.id = :reservationId")
    List<ReservationItem> findByReservationId(@Param("reservationId") Long reservationId);
}
