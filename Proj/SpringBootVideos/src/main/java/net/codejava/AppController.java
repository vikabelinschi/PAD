package net.codejava;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private VideoRepository videoRepo;
	private  CustomVideoDetailsService videoService;
	
	@GetMapping("")
	public String listVideos(Model model) {
		List<Video> listVideos = videoRepo.findAll();
		model.addAttribute("listVideos", listVideos);
		
		return "videos";
	}


	@GetMapping("/add_video")
	public String newVideoForm(Model model) {
			model.addAttribute("video", new Video());

			return "add_video";
	}

	@PostMapping("/added")
	public Video newVideo(Video newVideo) {
		return videoRepo.save(newVideo);
	}

	@GetMapping("/searchVideo/{title}")
	public String searchVideos(String title) {
		CustomVideoDetails video = videoService.loadVideoByTitle(title);
		return "video/{title}";
	}
}
