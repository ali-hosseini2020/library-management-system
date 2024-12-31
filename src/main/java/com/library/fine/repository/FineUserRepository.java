package com.library.fine.repository;
import com.library.fine.FineUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FineUserRepository extends JpaRepository<FineUser, Long> {

    @Query("SELECT fu FROM FineUser fu WHERE fu.firstName LIKE %:firstName% OR fu.lastName LIKE %:lastName%")
    List<FineUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT fu FROM FineUser fu WHERE fu.email LIKE %:email%")
    List<FineUser> findByEmailContaining(@Param("email") String email);
}
