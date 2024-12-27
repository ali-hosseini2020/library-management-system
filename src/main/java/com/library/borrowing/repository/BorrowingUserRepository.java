package com.library.borrowing.repository;
import com.library.borrowing.BorrowingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BorrowingUserRepository extends JpaRepository<BorrowingUser, Long> {

    @Query("SELECT bu FROM BorrowingUser bu WHERE bu.firstName LIKE %:firstName% OR bu.lastName LIKE %:lastName%")
    List<BorrowingUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT bu FROM BorrowingUser bu WHERE bu.email LIKE %:email%")
    List<BorrowingUser> findByEmailContaining(@Param("email") String email);
}

