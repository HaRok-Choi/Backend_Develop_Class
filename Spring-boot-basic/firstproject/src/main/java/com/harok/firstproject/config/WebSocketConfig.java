package com.harok.firstproject.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.harok.firstproject.provider.WebSocketProvider;

import lombok.RequiredArgsConstructor;

@EnableWebSocket
@Configuration
@RequiredArgsConstructor
public class WebSocketConfig implements WebSocketConfigurer {

    private final WebSocketProvider webSocketProvider;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        
        //@ (핸들러 객체, URL지정) 해서 작성하면 됨
        registry
            .addHandler(webSocketProvider, "/web-socket")
            .setAllowedOrigins("*");

    }
    
}
