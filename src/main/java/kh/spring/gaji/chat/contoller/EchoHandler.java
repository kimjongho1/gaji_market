package kh.spring.gaji.chat.contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@RequestMapping("/echo")
public class EchoHandler extends TextWebSocketHandler {
	
	// websocket 연결 시 
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    }
	
	// 클라이언트가 웹소켓 서버로 메세지를 전송했을 때 실행
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		super.handleTextMessage(session, message);
	}
	
	// websocket 연결 종료 시 
	@Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
 
    }
	
}
