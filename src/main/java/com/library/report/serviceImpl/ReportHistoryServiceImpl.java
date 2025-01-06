package com.library.report.serviceImpl;
import com.library.report.ReportHistory;
import com.library.report.dto.ReportHistoryDTO;
import com.library.report.mapper.ReportHistoryMapper;
import com.library.report.repository.ReportHistoryRepository;
import com.library.report.service.ReportHistoryService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportHistoryServiceImpl implements ReportHistoryService {

    @Autowired
    private ReportHistoryRepository reportHistoryRepository;

    @Autowired
    private ReportHistoryMapper reportHistoryMapper;

    @Override
    public List<ReportHistoryDTO> getAllReportHistories() {
        List<ReportHistory> reportHistories = reportHistoryRepository.findAll();
        return reportHistories.stream()
                .map(reportHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportHistoryDTO getReportHistoryById(Long id) {
        ReportHistory reportHistory = reportHistoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report history not found with id " + id));
        return reportHistoryMapper.toDTO(reportHistory);
    }

    @Override
    public ReportHistoryDTO saveReportHistory(ReportHistoryDTO reportHistoryDTO) {
        ReportHistory reportHistory = reportHistoryMapper.toEntity(reportHistoryDTO);
        ReportHistory savedReportHistory = reportHistoryRepository.save(reportHistory);
        return reportHistoryMapper.toDTO(savedReportHistory);
    }

    @Override
    public void deleteReportHistory(Long id) {
        if (!reportHistoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report history not found with id " + id);
        }
        reportHistoryRepository.deleteById(id);
    }

    @Override
    public List<ReportHistoryDTO> findReportHistoriesByReportId(Long reportId) {
        List<ReportHistory> reportHistories = reportHistoryRepository.findByReportId(reportId);
        return reportHistories.stream()
                .map(reportHistoryMapper::toDTO)
                .collect(Collectors.toList());
    }
}
