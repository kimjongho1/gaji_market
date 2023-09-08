package kh.spring.gaji.chat.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {
	

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    }
	
	// websocket 연결 종료 시 
	@Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
 
    }
}
