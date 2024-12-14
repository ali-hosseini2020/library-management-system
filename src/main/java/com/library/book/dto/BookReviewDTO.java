package com.library.book.dto;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookReviewDTO {
    private Long id;
    private String reviewText;
    private Integer rating;
    private LocalDateTime reviewDate;
    private Long userId; // Assuming there is a User entity
}