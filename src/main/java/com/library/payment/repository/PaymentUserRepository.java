package com.library.payment.repository;
import com.library.payment.PaymentUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentUserRepository extends JpaRepository<PaymentUser, Long> {

    @Query("SELECT pu FROM PaymentUser pu WHERE pu.firstName LIKE %:firstName% OR pu.lastName LIKE %:lastName%")
    List<PaymentUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT pu FROM PaymentUser pu WHERE pu.email LIKE %:email%")
    List<PaymentUser> findByEmailContaining(@Param("email") String email);
}
