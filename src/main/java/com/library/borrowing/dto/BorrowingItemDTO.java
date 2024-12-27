package com.library.borrowing.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BorrowingItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;
    private Long borrowingId;
}
