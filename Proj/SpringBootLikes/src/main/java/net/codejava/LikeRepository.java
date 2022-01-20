package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("SELECT u FROM Like u WHERE u.video_id = ?1")
    public List<Like> findByVideoId(Long video_id);

    @Query("SELECT u FROM Like u WHERE u.video_id = ?1 AND u.user_id = ?2")
    public String deleteLike(Long video_id, Long user_id);

}