package net.codejava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepo;

    public Integer showVideoLikes(Long video_id) {
        List<Like> likes = likeRepo.findByVideoId(video_id);
        Integer likes_nr = likes.size();
        return Integer.valueOf(likes_nr);
    }

    public String removeLike(Long video_id, Long user_id) {
        Like deletedLike = likeRepo.deleteLike(video_id,user_id);
        likeRepo.deleteById(deletedLike.getId());
        return "removed_like";
    }

}
