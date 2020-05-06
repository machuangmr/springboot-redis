package com.example.demo.controller;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {

    @Autowired
    private RedisService redisService;

    @PostMapping("/test/redisservice")
    public String testRedis() {
        if (redisService.set("123", "456")) {
            return "success";
        }
        return "failed";
    }
    @GetMapping("/test/get")
    public String testGetRedis() {
        return (String) redisService.getValue("123");
    }
}
