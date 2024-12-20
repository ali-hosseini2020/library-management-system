package com.library.book.repository;

import com.library.book.BookEdition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookEditionRepository extends JpaRepository<BookEdition, Long> {

    @Query("SELECT be FROM BookEdition be WHERE be.editionName LIKE %:editionName%")
    List<BookEdition> findByEditionNameContaining(@Param("editionName") String editionName);
}
