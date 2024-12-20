package com.library.book.repository;

import com.library.book.BookLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookLocationRepository extends JpaRepository<BookLocation, Long> {

    @Query("SELECT bl FROM BookLocation bl WHERE bl.shelf LIKE %:shelf%")
    List<BookLocation> findByShelfContaining(@Param("shelf") String shelf);

    @Query("SELECT bl FROM BookLocation bl WHERE bl.section LIKE %:section%")
    List<BookLocation> findBySectionContaining(@Param("section") String section);
}
