package com.library.report.service;
import com.library.report.dto.ReportHistoryDTO;
import java.util.List;

public interface ReportHistoryService {
    List<ReportHistoryDTO> getAllReportHistories();
    ReportHistoryDTO getReportHistoryById(Long id);
    ReportHistoryDTO saveReportHistory(ReportHistoryDTO reportHistoryDTO);
    void deleteReportHistory(Long id);
    List<ReportHistoryDTO> findReportHistoriesByReportId(Long reportId);
}
