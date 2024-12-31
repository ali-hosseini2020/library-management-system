package com.library.fine.repository;
import com.library.fine.Fine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FineRepository extends JpaRepository<Fine, Long> {

    @Query("SELECT f FROM Fine f WHERE f.user.id = :userId")
    List<Fine> findByUserId(@Param("userId") Long userId);

    @Query("SELECT f FROM Fine f WHERE f.status = :status")
    List<Fine> findByStatus(@Param("status") String status);
}
