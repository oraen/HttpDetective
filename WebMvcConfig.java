package com.oraen.yagaobox_hzu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Resource
    HandlerInterceptor visitorRegistration;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

   //     System.out.println("添加拦截器");
        // TODO Auto-generated method stub
    //    registry.addInterceptor(visitorRegistration)
                // 拦截路劲
      //          .addPathPatterns("/**");

    }
}
