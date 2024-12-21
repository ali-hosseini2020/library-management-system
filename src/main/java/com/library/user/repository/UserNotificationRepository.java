package com.library.user.repository;

import com.library.user.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Long> {

    @Query("SELECT un FROM UserNotification un WHERE un.user.id = :userId AND un.isRead = false")
    List<UserNotification> findUnreadNotificationsByUserId(@Param("userId") Long userId);

    @Query("SELECT un FROM UserNotification un WHERE un.user.id = :userId AND un.isRead = true")
    List<UserNotification> findReadNotificationsByUserId(@Param("userId") Long userId);
}
