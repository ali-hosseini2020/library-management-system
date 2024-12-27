package com.library.borrowing.repository;
import com.library.borrowing.BorrowingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingHistoryRepository extends JpaRepository<BorrowingHistory, Long> {

    @Query("SELECT bh FROM BorrowingHistory bh WHERE bh.borrowing.id = :borrowingId")
    List<BorrowingHistory> findByBorrowingId(@Param("borrowingId") Long borrowingId);
}

