package net.codejava;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class AppController {

	@Autowired
	private VideoRepository videoRepo;
	@Autowired
	private  CustomVideoDetailsService videoService;
	
	@GetMapping("")
	public List<Video> listVideos(Model model) {
		List<Video> listVideos = videoRepo.findAll();
		model.addAttribute("listVideos", listVideos);
		
		return listVideos;
	}


	@GetMapping("/add_video")
	public String newVideoForm(Model model) {
			model.addAttribute("video", new Video());

			return "add_video";
	}

	@GetMapping("/{video_id}")
	public Optional<Video> loadVideoById(@PathVariable String video_id) {
		Optional<Video> video = videoService.loadVideoById(video_id);
		System.out.println(video_id);
		return video;
	}

	@PostMapping("/added")
	public Video newVideo(Video newVideo) {
		return videoRepo.save(newVideo);
	}

	@GetMapping("/searchVideo/{title}")
	public String searchVideos(@PathVariable String title) {
		CustomVideoDetails video = videoService.loadVideoByTitle(title);
		return "video/{title}";
	}
}
