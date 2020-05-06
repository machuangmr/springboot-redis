package com.example.demo.service;

import com.example.demo.util.Const;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService{

    @Autowired
    private RedisService redisService;

    @Override
    public String createToken() {
        String str = UUID.randomUUID().toString().replace("-", "");
        //创建token后，放入redis中，
       try {
           StringBuffer token = new StringBuffer();
           String key = token.append(Const.TOKEN_PREFIX).append(str).toString();
           redisService.setEx(key, key, 10000L);
           if (!StringUtils.isEmpty(key)) {
               return key;
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
        return null;
    }

    @Override
    public boolean checkToken(HttpServletRequest request) {
        String token  = request.getHeader(Const.TOKEN_NAME);
        log.info("tokenservice 中token={}", token);
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("header中未获取到token");
        }

        if (!redisService.exists(token)) {
            throw new IllegalArgumentException("redis 中不存在token");
        }

        boolean remove = redisService.remove2(token);
        if (!remove) {
            throw new IllegalArgumentException("删除token失败");
        }
        return true;
    }
}
