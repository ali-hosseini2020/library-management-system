package com.library.book.repository;

import com.library.book.BookSeries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookSeriesRepository extends JpaRepository<BookSeries, Long> {

    @Query("SELECT bs FROM BookSeries bs WHERE bs.seriesName LIKE %:seriesName%")
    List<BookSeries> findBySeriesNameContaining(@Param("seriesName") String seriesName);
}
