package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {
    /**
     *  redis工具类
     */

    @Autowired
    private RedisTemplate redisTemplate;

    // 写入缓存
    public boolean set(String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
      return result;
    }
    // 设置缓存过期时间
    public boolean setEx(String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    // 判断缓存中是否存在对应的key值
    public boolean exists (String key) {
//        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
//        RedisOperations<Serializable, Object> operations = valueOperations.getOperations();
//        Boolean aBoolean = operations.hasKey(key);
        return redisTemplate.hasKey(key);
    }

//    //删除redis中对应的key；
//    public boolean remove(String key) {
//        boolean result = false;
//        //判断是否存在，然后删除掉
//      if (exists(key)) {
//          result = redisTemplate.delete(key);
//      }
//      return result;
//    }
    //删除redis中对应的key值
    public boolean remove2(String key) {
        if (exists(key)) {
            return redisTemplate.delete(key);
        }
        return false;
    }

    //获取到redis中对应的值
    public Object getValue(String key) {
        ValueOperations<Serializable, Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }
}
