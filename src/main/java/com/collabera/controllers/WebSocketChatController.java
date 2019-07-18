package com.collabera.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;

import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.collabera.models.*;
import com.collabera.models.WebSocketChatMessage;
import com.collabera.repositories.*;
@Controller
public class WebSocketChatController {

	@Autowired
	private SimpMessageSendingOperations template;
	
	@Autowired
	UserRepository UserService;
	
	@Autowired
	ChatRoomRepository ChatService;
	
	@Autowired
	MessagesRepository MessageService;

	

	@MessageMapping("/chat/{roomId}/sendMessage")
	public void sendMessage(@DestinationVariable String roomId, @Payload WebSocketChatMessage chatMessage) {
		
		
		//post message to db here
		
		System.out.println(chatMessage.toString());
		
		Messages message = new Messages();
		message.setMessage(chatMessage.getMessage());
		message.setSender(UserService.findById(chatMessage.getSender()).get());
		message.setChatRooms(ChatService.findById(chatMessage.getChatRoom()).get());

		MessageService.save(message);
		
		
		
		//create db message here
		// dbMessage.setMessage(  )
		
		
		template.convertAndSend(String.format("/channel/%s", roomId), chatMessage);
	}

	@MessageMapping("/chat/{roomId}/addUser")
	public void addUser(@DestinationVariable String roomId, @Payload WebSocketChatMessage chatMessage,
			SimpMessageHeaderAccessor accessor) {
		
		System.out.println("someone has joined the chat");
		
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
