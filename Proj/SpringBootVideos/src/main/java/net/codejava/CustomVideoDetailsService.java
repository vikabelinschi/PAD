package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

@Service
public class CustomVideoDetailsService {

    @Autowired
    private VideoRepository videoRepo;

    public CustomVideoDetails loadVideoByTitle(String title) throws HttpClientErrorException.NotFound  {
        Video video = videoRepo.findByTitle(title);
        return new CustomVideoDetails(video);
    }

}
