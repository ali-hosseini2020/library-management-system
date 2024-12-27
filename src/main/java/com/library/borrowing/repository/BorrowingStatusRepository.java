package com.library.borrowing.repository;
import com.library.borrowing.BorrowingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingStatusRepository extends JpaRepository<BorrowingStatus, Long> {

    @Query("SELECT bs FROM BorrowingStatus bs WHERE bs.borrowing.id = :borrowingId")
    List<BorrowingStatus> findByBorrowingId(@Param("borrowingId") Long borrowingId);
}
