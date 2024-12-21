package com.library.library.repository;
import com.library.library.LibraryUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryUserRepository extends JpaRepository<LibraryUser, Long> {

    @Query("SELECT lu FROM LibraryUser lu WHERE lu.firstName LIKE %:firstName% OR lu.lastName LIKE %:lastName%")
    List<LibraryUser> findByFirstNameOrLastNameContaining(@Param("firstName") String firstName, @Param("lastName") String lastName);

    @Query("SELECT lu FROM LibraryUser lu WHERE lu.email LIKE %:email%")
    List<LibraryUser> findByEmailContaining(@Param("email") String email);

    @Query("SELECT lu FROM LibraryUser lu WHERE lu.library.id = :libraryId")
    List<LibraryUser> findByLibraryId(@Param("libraryId") Long libraryId);

    @Query("SELECT lu FROM LibraryUser lu WHERE lu.branch.id = :branchId")
    List<LibraryUser> findByBranchId(@Param("branchId") Long branchId);
}