package com.library.borrowing.repository;
import com.library.borrowing.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {

    @Query("SELECT b FROM Borrowing b WHERE b.user.id = :userId")
    List<Borrowing> findByUserId(@Param("userId") Long userId);

    @Query("SELECT b FROM Borrowing b WHERE b.status = :status")
    List<Borrowing> findByStatus(@Param("status") String status);
}
