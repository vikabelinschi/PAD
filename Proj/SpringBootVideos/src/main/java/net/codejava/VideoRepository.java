package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query(value = "SELECT * FROM Videos WHERE title = ?1", nativeQuery = true)
    public Video findByTitle(String title);

    @Query(value = "SELECT * FROM Videos WHERE id = ?1", nativeQuery = true)
    public Optional<Video> findById(String id);

}
