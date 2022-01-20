package net.codejava;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("SELECT u FROM Comment u WHERE u.video_id = ?1")
    public List<Comment> findByVideoId(Long video_id);

    @Query("SELECT u FROM Comment u WHERE u.video_id = ?1 AND u.user_id = ?2")
    public String deleteComment(Long video_id, Long user_id);

}