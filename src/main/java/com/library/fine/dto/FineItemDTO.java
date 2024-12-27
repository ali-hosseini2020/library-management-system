package com.library.fine.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineItemDTO {
    private Long id;
    private String itemName;
    private String itemDescription;
    private Long fineId;
}
