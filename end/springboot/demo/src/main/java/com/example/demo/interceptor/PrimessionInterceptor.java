package com.example.demo.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import io.micrometer.common.util.StringUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class PrimessionInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String token = request.getParameter("token");
        if (!StringUtils.isEmpty(token)) {
            if ("123456".equals(token)) {
                return true;
            }
        }
        response.setContentType("text/html;charset=uTF-8");
        response.getWriter().print("権限不足");
        return false;
    }

}
