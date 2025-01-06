package com.library.report.controller;
import com.library.report.dto.ReportStatusDTO;
import com.library.report.service.ReportStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/report-statuses")
public class ReportStatusController {

    @Autowired
    private ReportStatusService reportStatusService;

    @GetMapping
    public List<ReportStatusDTO> getAllReportStatuses() {
        return reportStatusService.getAllReportStatuses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportStatusDTO> getReportStatusById(@PathVariable Long id) {
        try {
            ReportStatusDTO reportStatusDTO = reportStatusService.getReportStatusById(id);
            return ResponseEntity.ok(reportStatusDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportStatusDTO> saveReportStatus(@RequestBody ReportStatusDTO reportStatusDTO) {
        ReportStatusDTO savedReportStatusDTO = reportStatusService.saveReportStatus(reportStatusDTO);
        return ResponseEntity.status(201).body(savedReportStatusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportStatus(@PathVariable Long id) {
        try {
            reportStatusService.deleteReportStatus(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/report/{reportId}")
    public List<ReportStatusDTO> findReportStatusesByReportId(@PathVariable Long reportId) {
        return reportStatusService.findReportStatusesByReportId(reportId);
    }
}
