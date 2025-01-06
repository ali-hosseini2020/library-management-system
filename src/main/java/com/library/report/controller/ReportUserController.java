package com.library.report.controller;

import com.library.report.dto.ReportUserDTO;
import com.library.report.service.ReportUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report-users")
public class ReportUserController {

    @Autowired
    private ReportUserService reportUserService;

    @GetMapping
    public List<ReportUserDTO> getAllReportUsers() {
        return reportUserService.getAllReportUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportUserDTO> getReportUserById(@PathVariable Long id) {
        try {
            ReportUserDTO reportUserDTO = reportUserService.getReportUserById(id);
            return ResponseEntity.ok(reportUserDTO);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PostMapping
    public ResponseEntity<ReportUserDTO> saveReportUser(@RequestBody ReportUserDTO reportUserDTO) {
        ReportUserDTO savedReportUserDTO = reportUserService.saveReportUser(reportUserDTO);
        return ResponseEntity.status(201).body(savedReportUserDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReportUser(@PathVariable Long id) {
        try {
            reportUserService.deleteReportUser(id);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).build();
        }
    }

    @GetMapping("/search/name")
    public List<ReportUserDTO> findReportUsersByName(@RequestParam String firstName, @RequestParam String lastName) {
        return reportUserService.findReportUsersByName(firstName, lastName);
    }

    @GetMapping("/search/email")
    public List<ReportUserDTO> findReportUsersByEmail(@RequestParam String email) {
        return reportUserService.findReportUsersByEmail(email);
    }
}
