package com.library.fine.repository;
import com.library.fine.FineHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FineHistoryRepository extends JpaRepository<FineHistory, Long> {

    @Query("SELECT fh FROM FineHistory fh WHERE fh.fine.id = :fineId")
    List<FineHistory> findByFineId(@Param("fineId") Long fineId);
}
