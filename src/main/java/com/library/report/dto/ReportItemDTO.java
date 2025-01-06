package com.library.report.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class ReportItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;
    private Long reportId;
}
