package com.cap.portal.interceptor;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CorsInterceptor implements HandlerInterceptor {
    @Value("${FRONTEND_BASE_URL}")
    private String FRONTEND_BASE_URL;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse response, Object o) throws Exception {
//        System.out.println("添加跨域支持");
        //添加跨域CORS
        response.addHeader("Access-Control-Max-Age", "1800");//30 min
        response.setHeader("Access-Control-Allow-Origin", "FRONTEND_BASE_URL");//前端服务器url
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With,content-type,Content-Type,token");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
