package com.collabera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.collabera.models.WebSocketChatMessage;

@Controller
public class WebSocketChatController {

	@Autowired
	private SimpMessageSendingOperations template;

	@MessageMapping("/chat/{roomId}/sendMessage")
	public void sendMessage(@DestinationVariable String roomId, @Payload WebSocketChatMessage chatMessage) {
		
		//post message to db here
		
		//create db message here
		// dbMessage.setMessage(  )
		
		
		template.convertAndSend(String.format("/channel/%s", roomId), chatMessage);
	}

	@MessageMapping("/chat/{roomId}/addUser")
	public void addUser(@DestinationVariable String roomId, @Payload WebSocketChatMessage chatMessage,
			SimpMessageHeaderAccessor accessor) {
		String currentRoomId = (String) accessor.getSessionAttributes().put("room_id", roomId);
		if (currentRoomId != null) {
			WebSocketChatMessage leaveMessage = new WebSocketChatMessage();
			
			leaveMessage.setType("Leave");
			leaveMessage.setSender(chatMessage.getSender());
			template.convertAndSend(String.format("/channel/%s", currentRoomId), leaveMessage);
		}
		accessor.getSessionAttributes().put("username", chatMessage.getSender());
		template.convertAndSend(String.format("/channel/%s", roomId), chatMessage);
	}

}
