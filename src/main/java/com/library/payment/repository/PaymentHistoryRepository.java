package com.library.payment.repository;
import com.library.payment.PaymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long> {

    @Query("SELECT ph FROM PaymentHistory ph WHERE ph.payment.id = :paymentId")
    List<PaymentHistory> findByPaymentId(@Param("paymentId") Long paymentId);
}
