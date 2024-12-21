package com.library.library.repository;
import com.library.library.LibraryMembership;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryMembershipRepository extends JpaRepository<LibraryMembership, Long> {

    @Query("SELECT lm FROM LibraryMembership lm WHERE lm.user.id = :userId AND lm.active = true")
    List<LibraryMembership> findActiveMembershipsByUserId(@Param("userId") Long userId);

    @Query("SELECT lm FROM LibraryMembership lm WHERE lm.user.id = :userId AND lm.active = false")
    List<LibraryMembership> findInactiveMembershipsByUserId(@Param("userId") Long userId);
}