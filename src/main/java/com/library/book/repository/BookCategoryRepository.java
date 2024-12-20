package com.library.book.repository;

import com.library.book.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

    @Query("SELECT bc FROM BookCategory bc WHERE bc.name LIKE %:name%")
    List<BookCategory> findByNameContaining(@Param("name") String name);
}
