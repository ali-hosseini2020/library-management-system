package com.library.reservation.repository;
import com.library.reservation.ReservationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReservationUserRepository extends JpaRepository<ReservationUser, Long> {

    @Query("SELECT ru FROM ReservationUser ru WHERE ru.firstName LIKE %:firstName% OR ru.lastName LIKE %:lastName%")
    List<ReservationUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT ru FROM ReservationUser ru WHERE ru.email LIKE %:email%")
    List<ReservationUser> findByEmailContaining(@Param("email") String email);
}
