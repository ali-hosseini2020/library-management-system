package com.library.book.dto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class AuthorDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String biography;
}