package com.library.borrowing.dto;
import com.library.customizedenum.BorrowingStatusType;
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
public class BorrowingDTO {
    private Long id;
    private LocalDateTime borrowingDate;
    private LocalDateTime dueDate;
    private BorrowingStatusType status;
    private BorrowingUserDTO user;
    private List<BorrowingItemDTO> items;
    private List<BorrowingHistoryDTO> history;
}
