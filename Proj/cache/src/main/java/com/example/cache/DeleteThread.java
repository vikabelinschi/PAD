package com.example.cache;

import lombok.SneakyThrows;
import java.time.LocalDateTime;
import java.util.Map;

public class DeleteThread extends Thread{
    @SneakyThrows
    @Override
    public void run() {
        for (Map.Entry<String, RequestEntity> entry : CacheMap.cache.entrySet()){
            String token = entry.getKey();
            RequestEntity request = entry.getValue();
            if(request.getTime().plusHours(3).isAfter(LocalDateTime.now())){
                CacheMap.cache.remove(token);
            }
        }
        sleep(60000);
    }
}