package com.library.fine.dto;
import com.library.customizedenum.FineStatusType;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class FineStatusDTO {
    private Long id;
    private FineStatusType status;
    private Long fineId;
}
