package com.example.cache;

import lombok.*;
import org.springframework.boot.web.servlet.server.Session;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class RequestEntity {

    private String endpoint;
    private Object body;
    private Object response;
    private LocalDateTime time;
}
