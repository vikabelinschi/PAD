package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private LikeService service;
	private  LikeRepository likeRepo;
	
	@GetMapping("/{video_id}")
	public Integer nrOfLikes(Long video_id) {
		Integer nrOfLikes = service.showVideoLikes(video_id);

		return nrOfLikes;
	}



	@DeleteMapping("/remove_like/{user_id}/{video_id}")
	public String removeLike(Long video_id, Long user_id) {
        service.removeLike(video_id,user_id);
			return "/{video_id}";
	}

	@PostMapping("/add_like")
	public Like newLike(Like newLike) {
		return likeRepo.save(newLike);
	}
}
