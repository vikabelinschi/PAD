package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

public class CommentService {

    @Autowired
    private CommentRepository commentRepo;

    public List<Comment> showVideoComments(Long video_id) {
        List<Comment> comments = commentRepo.findByVideoId(video_id);
        return comments;
    }

    public String removeComment(Long video_id, Long user_id) {
        Comment deletedComment = commentRepo.deleteComment(video_id,user_id);
        commentRepo.deleteById(deletedComment.getId());
        return "removed_comment";
    }
}
