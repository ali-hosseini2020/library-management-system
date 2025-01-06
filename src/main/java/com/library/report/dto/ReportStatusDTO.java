package com.library.report.dto;
import com.library.customizedenum.ReportStatusType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReportStatusDTO {
    private Long id;
    private ReportStatusType status;
    private Long reportId;
}
