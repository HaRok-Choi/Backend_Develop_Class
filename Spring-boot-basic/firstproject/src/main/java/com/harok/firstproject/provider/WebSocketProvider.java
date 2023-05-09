package com.harok.firstproject.provider;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class WebSocketProvider extends TextWebSocketHandler{ //@ 실제로는 Handler 파일로 만들어서 하는게 맞다

    //# 1. 연결
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {

	}
    //# 2. 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        
	}

    //# 3. 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        
	}

}
