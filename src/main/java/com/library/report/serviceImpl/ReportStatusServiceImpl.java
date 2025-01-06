package com.library.report.serviceImpl;
import com.library.report.ReportStatus;
import com.library.report.dto.ReportStatusDTO;
import com.library.report.mapper.ReportStatusMapper;
import com.library.report.repository.ReportStatusRepository;
import com.library.report.service.ReportStatusService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportStatusServiceImpl implements ReportStatusService {

    @Autowired
    private ReportStatusRepository reportStatusRepository;

    @Autowired
    private ReportStatusMapper reportStatusMapper;

    @Override
    public List<ReportStatusDTO> getAllReportStatuses() {
        List<ReportStatus> reportStatuses = reportStatusRepository.findAll();
        return reportStatuses.stream()
                .map(reportStatusMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportStatusDTO getReportStatusById(Long id) {
        ReportStatus reportStatus = reportStatusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report status not found with id " + id));
        return reportStatusMapper.toDTO(reportStatus);
    }

    @Override
    public ReportStatusDTO saveReportStatus(ReportStatusDTO reportStatusDTO) {
        ReportStatus reportStatus = reportStatusMapper.toEntity(reportStatusDTO);
        ReportStatus savedReportStatus = reportStatusRepository.save(reportStatus);
        return reportStatusMapper.toDTO(savedReportStatus);
    }

    @Override
    public void deleteReportStatus(Long id) {
        if (!reportStatusRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report status not found with id " + id);
        }
        reportStatusRepository.deleteById(id);
    }

    @Override
    public List<ReportStatusDTO> findReportStatusesByReportId(Long reportId) {
        List<ReportStatus> reportStatuses = reportStatusRepository.findByReportId(reportId);
        return reportStatuses.stream()
                .map(reportStatusMapper::toDTO)
                .collect(Collectors.toList());
    }
}
