package net.codejava;

import java.util.Collection;



public class CustomVideoDetails {

    private Video video;


    public CustomVideoDetails(Video video) {
        this.video = video;
    }

    public String getTitle() {
        return video.getTitle();
    }
    
    public String getAddress() {
        return video.getAddress();
    }
    
    public String getDescription() {
        return video.getDescription();
    }
    
    public boolean isEnabled() {
        return true;
    }

}
