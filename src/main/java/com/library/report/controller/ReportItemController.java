package com.library.report.controller;
import com.library.report.dto.ReportItemDTO;
import com.library.report.service.ReportItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/report-items")
public class ReportItemController {

    @Autowired
    private ReportItemService reportItemService;

    @GetMapping
    public List<ReportItemDTO> getAllReportItems() {
        return reportItemService.getAllReportItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportItemDTO> getReportItemById(@PathVariable Long id) {
        try {
            ReportItemDTO reportItemDTO = reportItemService.getReportItemById(id);
            return ResponseEntity.ok(reportItemDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportItemDTO> saveReportItem(@RequestBody ReportItemDTO reportItemDTO) {
        ReportItemDTO savedReportItemDTO = reportItemService.saveReportItem(reportItemDTO);
        return ResponseEntity.status(201).body(savedReportItemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportItem(@PathVariable Long id) {
        try {
            reportItemService.deleteReportItem(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/report/{reportId}")
    public List<ReportItemDTO> findReportItemsByReportId(@PathVariable Long reportId) {
        return reportItemService.findReportItemsByReportId(reportId);
    }
}
