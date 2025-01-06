package com.library.report.service;
import com.library.report.dto.ReportStatusDTO;
import java.util.List;

public interface ReportStatusService {
    List<ReportStatusDTO> getAllReportStatuses();
    ReportStatusDTO getReportStatusById(Long id);
    ReportStatusDTO saveReportStatus(ReportStatusDTO reportStatusDTO);
    void deleteReportStatus(Long id);
    List<ReportStatusDTO> findReportStatusesByReportId(Long reportId);
}
