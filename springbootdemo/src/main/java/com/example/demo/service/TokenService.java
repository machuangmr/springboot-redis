package com.example.demo.service;

import javax.servlet.http.HttpServletRequest;

/**
 *  token 服务主要有两个功能
 *  1、创建token
 *  2、校验token
 */
public interface TokenService {

    public String createToken();

    // 因为token 存在于我们的requst的head中
    public boolean checkToken(HttpServletRequest request);
}
