package com.library.book;
import com.library.book2.models.Book;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "book_locations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class BookLocation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String locationName;

    @OneToMany(mappedBy = "location")
    private List<Book> books;  // Bidirectional relationship
}