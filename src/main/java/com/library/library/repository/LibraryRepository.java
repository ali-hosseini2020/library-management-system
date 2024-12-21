package com.library.library.repository;
import com.library.library.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

    @Query("SELECT l FROM Library l WHERE l.name LIKE %:name%")
    List<Library> findByNameContaining(@Param("name") String name);

    @Query("SELECT l FROM Library l WHERE l.address LIKE %:address%")
    List<Library> findByAddressContaining(@Param("address") String address);
}
