package com.library.fine.dto;
import com.library.customizedenum.FineStatusType;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineHistoryDTO {
    private Long id;
    private Long fineId;
    private LocalDateTime actionDate;
    private FineStatusType status;
    private String notes;
}
