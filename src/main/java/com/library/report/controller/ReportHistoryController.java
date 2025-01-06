package com.library.report.controller;
import com.library.report.dto.ReportHistoryDTO;
import com.library.report.service.ReportHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/report-histories")
public class ReportHistoryController {

    @Autowired
    private ReportHistoryService reportHistoryService;

    @GetMapping
    public List<ReportHistoryDTO> getAllReportHistories() {
        return reportHistoryService.getAllReportHistories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportHistoryDTO> getReportHistoryById(@PathVariable Long id) {
        try {
            ReportHistoryDTO reportHistoryDTO = reportHistoryService.getReportHistoryById(id);
            return ResponseEntity.ok(reportHistoryDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportHistoryDTO> saveReportHistory(@RequestBody ReportHistoryDTO reportHistoryDTO) {
        ReportHistoryDTO savedReportHistoryDTO = reportHistoryService.saveReportHistory(reportHistoryDTO);
        return ResponseEntity.status(201).body(savedReportHistoryDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportHistory(@PathVariable Long id) {
        try {
            reportHistoryService.deleteReportHistory(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/report/{reportId}")
    public List<ReportHistoryDTO> findReportHistoriesByReportId(@PathVariable Long reportId) {
        return reportHistoryService.findReportHistoriesByReportId(reportId);
    }
}
