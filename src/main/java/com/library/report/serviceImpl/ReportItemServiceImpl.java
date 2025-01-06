package com.library.report.serviceImpl;
import com.library.report.ReportItem;
import com.library.report.dto.ReportItemDTO;
import com.library.report.mapper.ReportItemMapper;
import com.library.report.repository.ReportItemRepository;
import com.library.report.service.ReportItemService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportItemServiceImpl implements ReportItemService {

    @Autowired
    private ReportItemRepository reportItemRepository;

    @Autowired
    private ReportItemMapper reportItemMapper;

    @Override
    public List<ReportItemDTO> getAllReportItems() {
        List<ReportItem> reportItems = reportItemRepository.findAll();
        return reportItems.stream()
                .map(reportItemMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportItemDTO getReportItemById(Long id) {
        ReportItem reportItem = reportItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report item not found with id " + id));
        return reportItemMapper.toDTO(reportItem);
    }

    @Override
    public ReportItemDTO saveReportItem(ReportItemDTO reportItemDTO) {
        ReportItem reportItem = reportItemMapper.toEntity(reportItemDTO);
        ReportItem savedReportItem = reportItemRepository.save(reportItem);
        return reportItemMapper.toDTO(savedReportItem);
    }

    @Override
    public void deleteReportItem(Long id) {
        if (!reportItemRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report item not found with id " + id);
        }
        reportItemRepository.deleteById(id);
    }

    @Override
    public List<ReportItemDTO> findReportItemsByReportId(Long reportId) {
        List<ReportItem> reportItems = reportItemRepository.findByReportId(reportId);
        return reportItems.stream()
                .map(reportItemMapper::toDTO)
                .collect(Collectors.toList());
    }
}
