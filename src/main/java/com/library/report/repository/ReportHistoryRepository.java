package com.library.report.repository;
import com.library.report.ReportHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportHistoryRepository extends JpaRepository<ReportHistory, Long> {

    @Query("SELECT rh FROM ReportHistory rh WHERE rh.report.id = :reportId")
    List<ReportHistory> findByReportId(@Param("reportId") Long reportId);
}
