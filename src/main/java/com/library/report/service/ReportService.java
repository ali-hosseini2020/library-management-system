package com.library.report.service;
import com.library.report.dto.ReportDTO;
import java.util.List;

public interface ReportService {
    List<ReportDTO> getAllReports();
    ReportDTO getReportById(Long id);
    ReportDTO saveReport(ReportDTO reportDTO);
    void deleteReport(Long id);
    List<ReportDTO> findReportsByUserId(Long userId);
    List<ReportDTO> findReportsByStatus(String status);
}
