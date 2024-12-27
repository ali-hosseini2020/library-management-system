package com.library.borrowing.dto;
import com.library.customizedenum.BorrowingStatusType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingStatusDTO {
    private Long id;
    private BorrowingStatusType status;
    private Long borrowingId;
}
