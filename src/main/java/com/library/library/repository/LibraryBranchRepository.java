package com.library.library.repository;
import com.library.library.LibraryBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryBranchRepository extends JpaRepository<LibraryBranch, Long> {

    @Query("SELECT lb FROM LibraryBranch lb WHERE lb.name LIKE %:name%")
    List<LibraryBranch> findByNameContaining(@Param("name") String name);

    @Query("SELECT lb FROM LibraryBranch lb WHERE lb.address LIKE %:address%")
    List<LibraryBranch> findByAddressContaining(@Param("address") String address);

    @Query("SELECT lb FROM LibraryBranch lb WHERE lb.library.id = :libraryId")
    List<LibraryBranch> findByLibraryId(@Param("libraryId") Long libraryId);
}