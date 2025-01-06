package com.library.report.repository;
import com.library.report.ReportItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ReportItemRepository extends JpaRepository<ReportItem, Long> {

    @Query("SELECT ri FROM ReportItem ri WHERE ri.report.id = :reportId")
    List<ReportItem> findByReportId(@Param("reportId") Long reportId);
}
