package com.library.fine.repository;
import com.library.fine.FineItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FineItemRepository extends JpaRepository<FineItem, Long> {

    @Query("SELECT fi FROM FineItem fi WHERE fi.fine.id = :fineId")
    List<FineItem> findByFineId(@Param("fineId") Long fineId);
}
