package com.library.borrowing.dto;
import com.library.customizedenum.BorrowingStatusType;
import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingHistoryDTO {
    private Long id;
    private Long borrowingId;
    private LocalDateTime actionDate;
    private BorrowingStatusType status;
    private String notes;
}
