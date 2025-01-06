package com.library.report.repository;
import com.library.report.ReportUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportUserRepository extends JpaRepository<ReportUser, Long> {

    @Query("SELECT ru FROM ReportUser ru WHERE ru.firstName LIKE %:firstName% OR ru.lastName LIKE %:lastName%")
    List<ReportUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT ru FROM ReportUser ru WHERE ru.email LIKE %:email%")
    List<ReportUser> findByEmailContaining(@Param("email") String email);
}
