package com.library.report.controller;
import com.library.report.dto.ReportDTO;
import com.library.report.service.ReportService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @GetMapping
    public List<ReportDTO> getAllReports() {
        return reportService.getAllReports();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportDTO> getReportById(@PathVariable Long id) {
        try {
            ReportDTO reportDTO = reportService.getReportById(id);
            return ResponseEntity.ok(reportDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportDTO> saveReport(@RequestBody ReportDTO reportDTO) {
        ReportDTO savedReportDTO = reportService.saveReport(reportDTO);
        return ResponseEntity.status(201).body(savedReportDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        try {
            reportService.deleteReport(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/user/{userId}")
    public List<ReportDTO> findReportsByUserId(@PathVariable Long userId) {
        return reportService.findReportsByUserId(userId);
    }

    @GetMapping("/search/status")
    public List<ReportDTO> findReportsByStatus(@RequestParam String status) {
        return reportService.findReportsByStatus(status);
    }
}
