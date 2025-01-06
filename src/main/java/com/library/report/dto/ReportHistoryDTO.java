package com.library.report.dto;
import com.library.customizedenum.ReportStatusType;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReportHistoryDTO {
    private Long id;
    private Long reportId;
    private LocalDateTime actionDate;
    private ReportStatusType status;
    private String notes;
}
