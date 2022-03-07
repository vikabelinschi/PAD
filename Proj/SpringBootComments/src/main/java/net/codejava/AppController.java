package net.codejava;

import java.rmi.ServerException;
import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private CommentService service;
	@Autowired
	private  CommentRepository commentRepo;
	
	@GetMapping("/{video_id}")
	public List<Comment> Comments(@PathVariable Long video_id) {
		List<Comment> comments = service.showVideoComments(video_id);

		return comments;
	}

	@DeleteMapping("/remove_comment/{user_id}/{video_id}")
	public String removeComment(@PathVariable Long video_id,@PathVariable Long user_id) {
		service.removeComment(video_id,user_id);
		return "/{video_id}";
	}

	@PostMapping(path = "/add_comment",  consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Comment> addComment(@RequestBody Comment newComment) {
		Comment comment = commentRepo.save(newComment);
			return new ResponseEntity<>(comment, HttpStatus.CREATED);
	}
}
