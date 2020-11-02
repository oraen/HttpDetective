package com.oraen.yagaobox_hzu.config;

import com.oraen.yagaobox_hzu.security.HttpDetective;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class Interceptor {

    @Autowired
    HttpDetective httpDetective;

    @Bean
    public HandlerInterceptor visitorRegistration(){

        return new HandlerInterceptor(){
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return httpDetective.inspection(request.getRemoteAddr());
            }
        };
    }
}
