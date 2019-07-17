package com.collabera.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

//import com.collabera.models.WebSocketChatMessage;

@Component
public class WebSocketChatEventListener {
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        System.out.println("Received a new web socket connection");
    }
    
		
	@EventListener
	public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
		StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

		
//		String username = (String) accessor.getSessionAttributes().get("username");
//		String roomId = (String)  accessor.getSessionAttributes().get("room_id");
//		
//		if(username != null) {
//			WebSocketChatMessage chatMessage = new WebSocketChatMessage();
//			chatMessage.setType("Leave");
//			chatMessage.setSender(username);
//			
//			messagingTemplate.convertAndSend(String.format("/channel/%s", roomId), chatMessage);
//		
//		}
	}

}