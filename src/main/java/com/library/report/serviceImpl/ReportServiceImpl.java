package com.library.report.serviceImpl;
import com.library.report.Report;
import com.library.report.dto.ReportDTO;
import com.library.report.mapper.ReportMapper;
import com.library.report.repository.ReportRepository;
import com.library.report.service.ReportService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<ReportDTO> getAllReports() {
        List<Report> reports = reportRepository.findAll();
        return reports.stream()
                .map(reportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportDTO getReportById(Long id) {
        Report report = reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report not found with id " + id));
        return reportMapper.toDTO(report);
    }

    @Override
    public ReportDTO saveReport(ReportDTO reportDTO) {
        Report report = reportMapper.toEntity(reportDTO);
        Report savedReport = reportRepository.save(report);
        return reportMapper.toDTO(savedReport);
    }

    @Override
    public void deleteReport(Long id) {
        if (!reportRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report not found with id " + id);
        }
        reportRepository.deleteById(id);
    }

    @Override
    public List<ReportDTO> findReportsByUserId(Long userId) {
        List<Report> reports = reportRepository.findByUserId(userId);
        return reports.stream()
                .map(reportMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportDTO> findReportsByStatus(String status) {
        List<Report> reports = reportRepository.findByStatus(status);
        return reports.stream()
                .map(reportMapper::toDTO)
                .collect(Collectors.toList());
    }
}
