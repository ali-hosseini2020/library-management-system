package com.library.report.service;
import com.library.report.dto.ReportUserDTO;
import java.util.List;

public interface ReportUserService {
    List<ReportUserDTO> getAllReportUsers();
    ReportUserDTO getReportUserById(Long id);
    ReportUserDTO saveReportUser(ReportUserDTO reportUserDTO);
    void deleteReportUser(Long id);
    List<ReportUserDTO> findReportUsersByName(String firstName, String lastName);
    List<ReportUserDTO> findReportUsersByEmail(String email);
}
