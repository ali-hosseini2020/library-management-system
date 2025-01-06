package com.library.report.serviceImpl;
import com.library.report.ReportUser;
import com.library.report.dto.ReportUserDTO;
import com.library.report.mapper.ReportUserMapper;
import com.library.report.repository.ReportUserRepository;
import com.library.report.service.ReportUserService;
import com.library.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReportUserServiceImpl implements ReportUserService {

    @Autowired
    private ReportUserRepository reportUserRepository;

    @Autowired
    private ReportUserMapper reportUserMapper;

    @Override
    public List<ReportUserDTO> getAllReportUsers() {
        List<ReportUser> reportUsers = reportUserRepository.findAll();
        return reportUsers.stream()
                .map(reportUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReportUserDTO getReportUserById(Long id) {
        ReportUser reportUser = reportUserRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Report user not found with id " + id));
        return reportUserMapper.toDTO(reportUser);
    }

    @Override
    public ReportUserDTO saveReportUser(ReportUserDTO reportUserDTO) {
        ReportUser reportUser = reportUserMapper.toEntity(reportUserDTO);
        ReportUser savedReportUser = reportUserRepository.save(reportUser);
        return reportUserMapper.toDTO(savedReportUser);
    }

    @Override
    public void deleteReportUser(Long id) {
        if (!reportUserRepository.existsById(id)) {
            throw new ResourceNotFoundException("Report user not found with id " + id);
        }
        reportUserRepository.deleteById(id);
    }

    @Override
    public List<ReportUserDTO> findReportUsersByName(String firstName, String lastName) {
        List<ReportUser> reportUsers = reportUserRepository.findByFirstNameOrLastNameContaining(firstName, lastName);
        return reportUsers.stream()
                .map(reportUserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReportUserDTO> findReportUsersByEmail(String email) {
        List<ReportUser> reportUsers = reportUserRepository.findByEmailContaining(email);
        return reportUsers.stream()
                .map(reportUserMapper::toDTO)
                .collect(Collectors.toList());
    }
}
