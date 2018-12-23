package com.Alice.springbootOA.config;

import com.Alice.springbootOA.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置自定义的拦截器、过滤器等
 * create by Alice
 * 2018/12/23  15:26
 */
@Configuration
public class MyServerConfig extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor())
                .addPathPatterns("/**");
    }


}
