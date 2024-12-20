package com.library.book.repository;

import com.library.book.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

    @Query("SELECT br FROM BookReview br WHERE br.book.id = :bookId")
    List<BookReview> findByBookId(@Param("bookId") Long bookId);

    @Query("SELECT br FROM BookReview br WHERE br.user.id = :userId")
    List<BookReview> findByUserId(@Param("userId") Long userId);
}
