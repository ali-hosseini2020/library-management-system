package com.library.book.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookEditionDTO {
    private Long id;
    private String editionName;
    private String description;
}