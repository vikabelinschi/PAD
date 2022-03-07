package net.codejava;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CacheDTO {
    private String endpoint;
    private Object username;
    private Object token;
    private Object response;
    private LocalDateTime time;
}