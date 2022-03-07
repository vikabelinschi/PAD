package com.example.cache;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class CacheController {

    @PostMapping("/caching")
    void add(@RequestHeader("token")String token, @RequestBody RequestEntity requestEntity){
        requestEntity.setTime(LocalDateTime.now());
        CacheMap.cache.put(token, requestEntity);
        System.out.println(CacheMap.cache);
    }
}