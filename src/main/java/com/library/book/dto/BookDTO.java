package com.library.book.dto;
import com.library.customizedenum.BookStatus;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Integer publicationYear;
    private String language;
    private Integer numberOfPages;
    private BookStatus status;
    private BookCategoryDTO category;
    private BookLocationDTO location;
    private List<BookTagDTO> tags;
    private List<BookReviewDTO> reviews;
    private BookEditionDTO edition;
    private List<AuthorDTO> authors;
    private PublisherDTO publisher;
    private BookSeriesDTO series;
}
