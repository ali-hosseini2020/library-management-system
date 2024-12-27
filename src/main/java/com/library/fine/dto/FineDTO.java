package com.library.fine.dto;
import com.library.customizedenum.FineStatusType;
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
public class FineDTO {
    private Long id;
    private LocalDateTime issueDate;
    private LocalDateTime dueDate;
    private FineStatusType status;
    private FineUserDTO user;
    private List<FineItemDTO> items;
    private List<FineHistoryDTO> history;
}
