package com.example.demo.security;


import com.example.demo.service.TokenService;
import com.example.demo.service.TokenServiceException;
import com.example.demo.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Component
public class AutoIdempotentInterceptor implements HandlerInterceptor {
    /**
     *  在过滤器中校验token，如果存在token，则在校验后删除掉，等请求第二次进来的时候
     *  校验redis中不存在token，则不能请求，完成幂等性的校验
     *
     */

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射在方法上直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        AutoIdement annotation = method.getAnnotation(AutoIdement.class);
        if (annotation != null) {
            // 如果有 @AutoIdement注解则需要进行判断
            try {
                return tokenService.checkToken(request);
            } catch (Exception e) {
               writeRetureJson(response, e.getMessage());
            }

        }
        // 如果没有@AutoIdement该注解，则直接放行
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
    /**
     *  返回的json值
     */

    private void writeRetureJson(HttpServletResponse response, String json) {
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        } catch (Exception e) {

        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
