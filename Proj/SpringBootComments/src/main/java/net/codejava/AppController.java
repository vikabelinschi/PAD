package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private CommentService service;
	private  CommentRepository commentRepo;
	
	@GetMapping("/{video_id}")
	public List<Comment> Comments(Long video_id) {
		List<Comment> comments = service.showVideoComments(video_id);

		return comments;
	}

	@DeleteMapping("/remove_comment/{user_id}/{video_id}")
	public String removeComment(Long video_id, Long user_id) {
        commentRepo.deleteComment(video_id, user_id);
			return "/{video_id}";
	}

	@PostMapping("/add_comment")
	public Comment newComment(Comment newComment) {
		return commentRepo.save(newComment);
	}
}
