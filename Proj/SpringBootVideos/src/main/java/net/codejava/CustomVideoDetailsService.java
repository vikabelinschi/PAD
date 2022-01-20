package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.client.HttpClientErrorException;

public class CustomVideoDetailsService {

    @Autowired
    private VideoRepository videoRepo;

    public CustomVideoDetails loadVideoByTitle(String title) throws HttpClientErrorException.NotFound  {
        Video video = videoRepo.findByTitle(title);
        if (video == null) {
            throw new UsernameNotFoundException("Video doesn't exist");
        }
        return new CustomVideoDetails(video);
    }

}
