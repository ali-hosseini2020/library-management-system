package com.library.library.dto;
import lombok.*;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class LibraryEventDTO {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime eventDate;
    private String location;
    private Long libraryId;
    private Long branchId;
}
