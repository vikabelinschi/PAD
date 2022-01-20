package net.codejava;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomVideoDetails {

    private Video video;

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

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
