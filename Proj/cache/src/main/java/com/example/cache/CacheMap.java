package com.example.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheMap {
    public static Map<String, RequestEntity> cache = new ConcurrentHashMap<>();
}