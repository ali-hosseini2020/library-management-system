package com.library.book.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookCategoryDTO {
    private Long id;
    private String name;
    private String description;
}
