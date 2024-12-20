package com.library.book.repository;

import com.library.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE a.firstName LIKE %:firstName% OR a.lastName LIKE %:lastName%")
    List<Author> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
