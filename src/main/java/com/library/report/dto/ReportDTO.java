package com.library.report.dto;
import com.library.customizedenum.ReportStatusType;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReportDTO {
    private Long id;
    private LocalDateTime reportDate;
    private String title;
    private String description;
    private ReportStatusType status;
    private ReportUserDTO user;
    private List<ReportItemDTO> items;
    private List<ReportHistoryDTO> history;
}
