package com.harok.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//# 스프링 설정과 관련된 것들만 넣음
@Configuration //@ <- Spring 설정 바꿀 수 있음
public class CorsConfig implements WebMvcConfigurer {
    //@ 보안상 전부 뚫어주는건 좋지 않음
    public void addCorsMappings(CorsRegistry registry) {
        //@ (/**, *) : 모든 리소스에 대해서 허용 
        registry
            //@ 어떤 mapping(path)에 대해서 허용 할건지
            .addMapping("/**")

            //@ 어떤 메서드를 처리 할건지
            .allowedMethods("*")

            //@ 어떠한 출처에 대해서 허용할건지
            //@ 일반적으로 웹개발할때 특정한것만 쓰고 싶으면 그 주소 적으면 됨
            .allowedOrigins("*");
	}


}
