package com.Alice.springbootOA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**
 * create by Alice
 * 2018/12/23  13:47
 */
@Configuration
public class JsonConfig {


    /**
     * 注入MappingJackson2JsonView
     * @return
     */
    @Bean
    public MappingJackson2JsonView jsonView(){
        return new MappingJackson2JsonView();
    }


}
