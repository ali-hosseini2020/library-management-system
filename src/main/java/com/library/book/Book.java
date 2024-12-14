package com.library.book;
import com.library.customizedenum.BookStatus;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
//import jakarta.persistence.*;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private BookStatus status; // Enum for book statuses

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookReview> reviews;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private BookSeries series;

    private String isbn;

    private Integer publicationYear;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private BookLocation location;
}

/*package com.library.book;

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private Integer publicationYear;
    private String language;
    private Integer numberOfPages;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private BookLocation location;

    @ManyToMany
    @JoinTable(
        name = "book_tags",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<BookTag> tags;

    @OneToMany(mappedBy = "book")
    private List<BookReview> reviews;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private BookEdition edition;

    @ManyToMany
    @JoinTable(
        name = "book_authors",
        joinColumns = @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private BookSeries series;
}
*/



/*
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String isbn;
    private Integer yearPublished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private BookLocation location;

    @ManyToMany
    @JoinTable(
            name = "book_tags",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<BookTag> tags;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookReview> reviews;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id")
    private BookEdition edition;

    @ManyToMany
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id")
    private BookSeries series;
}

*/




/*@Entity
@Table(name = "books")
@Data                  // Generates getters, setters, toString(), equals(), and hashCode() methods
@AllArgsConstructor   // Generates a constructor with all fields
@NoArgsConstructor    // Generates a no-args constructor (required by JPA)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "isbn", nullable = false, unique = true, length = 20)
    private String isbn;

    @Column(name = "year_published")
    private Integer yearPublished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private BookCategory category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", referencedColumnName = "id", nullable = false)
    private BookLocation location;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookTag> tags;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BookReview> reviews;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "edition_id", referencedColumnName = "id", nullable = false)
    private BookEdition edition;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "book_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publisher_id", referencedColumnName = "id", nullable = false)
    private Publisher publisher;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", referencedColumnName = "id")
    private BookSeries series;

    // The constructor, getters, setters, toString(), equals(), and hashCode methods are now generated automatically
}*/

   /*
    private String title;
    private String isbn;
    private Integer yearPublished;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private BookCategory category;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private BookLocation location;

    @ManyToMany
    @JoinTable(name = "book_tag", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<BookTag> tags;

    @OneToMany(mappedBy = "book")
    private List<BookReview> reviews;

    @ManyToOne
    @JoinColumn(name = "edition_id")
    private BookEdition edition;

    @ManyToMany
    @JoinTable(name = "book_author", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> authors;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private BookSeries series;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private Boolean isActive = true;

    // Getters, Setters, and Business Methods (if needed)
*/

