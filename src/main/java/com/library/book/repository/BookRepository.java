package com.library.book.repository;

import com.library.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.title LIKE %:title%")
    List<Book> findByTitleContaining(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE b.status = :status")
    List<Book> findByStatus(@Param("status") String status);

    @Query("SELECT b FROM Book b WHERE b.category.id = :categoryId")
    List<Book> findByCategoryId(@Param("categoryId") Long categoryId);

    @Query("SELECT b FROM Book b WHERE b.location.id = :locationId")
    List<Book> findByLocationId(@Param("locationId") Long locationId);

    @Query("SELECT b FROM Book b JOIN b.tags t WHERE t.id = :tagId")
    List<Book> findByTagId(@Param("tagId") Long tagId);

    @Query("SELECT b FROM Book b JOIN b.authors a WHERE a.id = :authorId")
    List<Book> findByAuthorId(@Param("authorId") Long authorId);

    @Query("SELECT b FROM Book b WHERE b.publisher.id = :publisherId")
    List<Book> findByPublisherId(@Param("publisherId") Long publisherId);

    @Query("SELECT b FROM Book b WHERE b.series.id = :seriesId")
    List<Book> findBySeriesId(@Param("seriesId") Long seriesId);
}
