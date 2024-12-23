package com.library.reservation.repository;
import com.library.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT r FROM Reservation r WHERE r.user.id = :userId")
    List<Reservation> findByUserId(@Param("userId") Long userId);

    @Query("SELECT r FROM Reservation r WHERE r.status = :status")
    List<Reservation> findByStatus(@Param("status") String status);
}
