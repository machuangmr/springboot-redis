package com.example.demo.controller;

import com.example.demo.security.AutoIdement;
import com.example.demo.service.TestService;
import com.example.demo.service.TokenService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class BusinessController {

    @Resource
    private TokenService tokenService;

    @Resource
    private TestService testService;



    @GetMapping("/get/token")
    public String getToken() {
        return tokenService.createToken();
    }

    @AutoIdement
    @PostMapping("/test/Idempotence")
    public String testIdempotence() {
        String result = testService.testIdempotence();
        if (!StringUtils.isEmpty(result)) {
            return result;
        }

        return "空的";
    }
}
