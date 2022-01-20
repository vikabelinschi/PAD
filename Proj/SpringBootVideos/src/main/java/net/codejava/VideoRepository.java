package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VideoRepository extends JpaRepository<Video, Long> {
    @Query("SELECT u FROM Video u WHERE u.title = ?1")
    public Video findByTitle(String title);

}
