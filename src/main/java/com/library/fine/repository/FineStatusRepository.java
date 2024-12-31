package com.library.fine.repository;
import com.library.fine.FineStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FineStatusRepository extends JpaRepository<FineStatus, Long> {

    @Query("SELECT fs FROM FineStatus fs WHERE fs.fine.id = :fineId")
    List<FineStatus> findByFineId(@Param("fineId") Long fineId);
}
