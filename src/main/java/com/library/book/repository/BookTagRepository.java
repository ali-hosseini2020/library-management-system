package com.library.book.repository;

import com.library.book.BookTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookTagRepository extends JpaRepository<BookTag, Long> {

    @Query("SELECT bt FROM BookTag bt WHERE bt.name LIKE %:name%")
    List<BookTag> findByNameContaining(@Param("name") String name);
}
