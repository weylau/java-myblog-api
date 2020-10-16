package com.weylau.javamyblogapi.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisClient {
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public void setWithExpire(String key, String value, Integer expire) {
        redisTemplate.opsForValue().set(key, value, expire);
    }

    public void setNeverExpire(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

}
