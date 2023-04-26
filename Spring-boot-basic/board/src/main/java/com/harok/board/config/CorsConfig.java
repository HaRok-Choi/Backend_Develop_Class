package com.harok.board.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//# 다른 출처와 자원을 공유하려 할 때
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    
    public void addCorsMappings(CorsRegistry registry) {
        registry
            .addMapping("/**")
            .allowedOrigins("*")
            .allowedMethods("*");
    }
}
