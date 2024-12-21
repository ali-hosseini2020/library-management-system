package com.library.library.repository;
import com.library.library.LibraryEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryEventRepository extends JpaRepository<LibraryEvent, Long> {

    @Query("SELECT le FROM LibraryEvent le WHERE le.name LIKE %:name%")
    List<LibraryEvent> findByNameContaining(@Param("name") String name);

    @Query("SELECT le FROM LibraryEvent le WHERE le.library.id = :libraryId")
    List<LibraryEvent> findByLibraryId(@Param("libraryId") Long libraryId);

    @Query("SELECT le FROM LibraryEvent le WHERE le.branch.id = :branchId")
    List<LibraryEvent> findByBranchId(@Param("branchId") Long branchId);
}