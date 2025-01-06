package com.library.report.service;
import com.library.report.dto.ReportItemDTO;
import java.util.List;

public interface ReportItemService {
    List<ReportItemDTO> getAllReportItems();
    ReportItemDTO getReportItemById(Long id);
    ReportItemDTO saveReportItem(ReportItemDTO reportItemDTO);
    void deleteReportItem(Long id);
    List<ReportItemDTO> findReportItemsByReportId(Long reportId);
}
