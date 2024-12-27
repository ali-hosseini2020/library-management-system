package com.library.borrowing.repository;
import com.library.borrowing.BorrowingItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingItemRepository extends JpaRepository<BorrowingItem, Long> {

    @Query("SELECT bi FROM BorrowingItem bi WHERE bi.borrowing.id = :borrowingId")
    List<BorrowingItem> findByBorrowingId(@Param("borrowingId") Long borrowingId);
}
