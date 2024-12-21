package com.library.user.repository;

import com.library.user.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {

    @Query("SELECT ua FROM UserAccount ua WHERE ua.username LIKE %:username%")
    List<UserAccount> findByUsernameContaining(@Param("username") String username);

    @Query("SELECT ua FROM UserAccount ua WHERE ua.user.id = :userId")
    List<UserAccount> findByUserId(@Param("userId") Long userId);
}
