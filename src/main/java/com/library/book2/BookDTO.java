package com.library.book2;

import com.library.book2.models.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookDTO {
    private Long id;

    @NotBlank(message = "Title is mandatory")
    @Size(max = 255, message = "Title must be less than 255 characters")
    private String title;

    @NotBlank(message = "ISBN is mandatory")
    @Size(max = 13, message = "ISBN must be less than 13 characters")
    private String isbn;

    @NotNull(message = "Year Published is mandatory")
    private Integer yearPublished;

    @NotNull(message = "Category is mandatory")
    private BookCategory category;

    @NotNull(message = "Location is mandatory")
    private BookLocation location;

    private List<BookTag> tags;
    private List<BookReview> reviews;
    private BookEdition edition;

    @NotNull(message = "Authors are mandatory")
    @Size(min = 1, message = "At least one author is required")
    private List<Author> authors;

    @NotNull(message = "Publisher is mandatory")
    private Publisher publisher;

    private BookSeries series;


}

 /*private Long id;
    private String title;    private String isbn;
    private Integer yearPublished;
    private BookCategory category;
    private BookLocation location;
    private List<BookTag> tags;
    private List<BookReview> reviews;
    private BookEdition edition;
    private List<Author> authors;
    private Publisher publisher;
    private BookSeries series;*/


/*package com.example.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values from serialization
public class BookDTO {

    private Long id;

    @NotNull(message = "Title cannot be null")
    @Size(min = 1, max = 255, message = "Title must be between 1 and 255 characters")
    private String title;

    @NotNull(message = "ISBN cannot be null")
    @Size(min = 10, max = 13, message = "ISBN must be between 10 and 13 characters")
    private String isbn;

    @Min(value = 1900, message = "Year Published should be greater than or equal to 1900")
    private Integer yearPublished;

    @JsonProperty("category") // Optional: Custom mapping for JSON property names
    private BookCategoryDTO category;

    @JsonProperty("location") // Optional: Custom mapping for JSON property names
    private BookLocationDTO location;

    private List<BookTagDTO> tags;

    private List<BookReviewDTO> reviews;

    private BookEditionDTO edition;

    private List<AuthorDTO> authors;

    private PublisherDTO publisher;

    private BookSeriesDTO series;
}
*/