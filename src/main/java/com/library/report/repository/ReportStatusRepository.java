package com.library.report.repository;
import com.library.report.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportStatusRepository extends JpaRepository<ReportStatus, Long> {

    @Query("SELECT rs FROM ReportStatus rs WHERE rs.report.id = :reportId")
    List<ReportStatus> findByReportId(@Param("reportId") Long reportId);
}
