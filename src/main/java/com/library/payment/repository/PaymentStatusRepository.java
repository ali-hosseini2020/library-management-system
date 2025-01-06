package com.library.payment.repository;
import com.library.payment.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentStatusRepository extends JpaRepository<PaymentStatus, Long> {

    @Query("SELECT ps FROM PaymentStatus ps WHERE ps.payment.id = :paymentId")
    List<PaymentStatus> findByPaymentId(@Param("paymentId") Long paymentId);
}
