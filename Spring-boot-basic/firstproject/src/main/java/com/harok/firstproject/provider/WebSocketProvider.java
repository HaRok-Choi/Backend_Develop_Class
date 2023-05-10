package com.harok.firstproject.provider;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

//@ 여기에서만 쓸 클래스
@Getter
@AllArgsConstructor
class SessionGroup {
    private String room;
    private WebSocketSession session;
}

@Component
//@ 실제로는 Handler 파일을 만들고 WebSocketHandler 하는게 맞다
public class WebSocketProvider extends TextWebSocketHandler{

    private List<SessionGroup> sessionList = new ArrayList<>();

    //# 1. 연결
    @Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String room = session.getHandshakeHeaders().getFirst("room"); 
        //@ getHandshakeHeaders: RequestHeader에 보내는것이랑 동일하다.
        //@ getFirst: 특정한 Header의 값을 가져올 수 있다.
        sessionList.add(new SessionGroup(room, session));
        System.out.println(room + " / " + session.getId() + " / Web Socket Connected!!");
	}

    //# 2. 메세지 송수신
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String room = session.getHandshakeHeaders().getFirst("room");
        for (SessionGroup sessionGroup: sessionList) {
            if (sessionGroup.getRoom().equals(room) && sessionGroup.getSession().equals(session)) {
                sessionGroup.getSession().sendMessage(message);
            }
            //@ sessionGroup.getSession().equals(session)
            //@ : 이걸 추가하면 같은 세션일때 메시지가 보이지 않는다.
        }
	}

    //# 3. 연결 해제
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getId() + " / Web Socket Closed!!");
        for (SessionGroup sessionGroup: sessionList) {
            if (sessionGroup.getSession().equals(session)) {
                sessionList.remove(sessionGroup);
            }
        }
	}

}
