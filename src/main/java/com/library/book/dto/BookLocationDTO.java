package com.library.book.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookLocationDTO {
    private Long id;
    private String shelf;
    private String section;
}