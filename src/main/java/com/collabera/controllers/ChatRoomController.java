package com.collabera.controllers;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.models.ArchivedMessages;
import com.collabera.models.ChatRooms;
import com.collabera.models.Messages;
import com.collabera.models.Users;
import com.collabera.repositories.ArchivedMessagesRepository;
import com.collabera.repositories.ChatRoomRepository;
import com.collabera.repositories.MessagesRepository;

@RestController
public class ChatRoomController {
	
	@Autowired
	ChatRoomRepository ChatRoomService;
	
	@Autowired
	MessagesRepository MessageService;
	
	@Autowired
	ArchivedMessagesRepository ArchivedMessageService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/chatrooms")
	public List<ChatRooms> getAllRooms(){
		return ChatRoomService.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/chatrooms/{id}")
	public ChatRooms getChatRoom(@PathVariable ObjectId id){
		Optional<ChatRooms> temp = ChatRoomService.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}
		return null;
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/chatrooms/userSpecific/{user}")
	public List<ChatRooms> getUserChatRooms(@PathVariable ObjectId user){
		List<ChatRooms> temp = ChatRoomService.findByUser1IdOrderByCreatedAsc(user);
		if(temp.isEmpty()) {
			temp = ChatRoomService.findByUser2IdOrderByCreatedAsc(user);
			if(temp.isEmpty()) {
				return null;
			} else {
				return temp;
			}
		}else {
			return temp;
		}
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/api/chatrooms")
	public ResponseEntity<String> createRoom(@RequestBody ChatRooms newRoom){
		newRoom.setCreated(new Date());
		ChatRoomService.save(newRoom);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Created!");
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/api/chatrooms/{id}")
	public ResponseEntity<String> deleteRoom(@PathVariable ObjectId id){
		List<Messages> messages = MessageService.deleteByChatRoomsId(id);
		ArchivedMessages aMessage;
		for(Messages m: messages) {
			aMessage = new ArchivedMessages(new ObjectId(m.getId()), m.getSender(), m.getMessage(), m.getChatRooms(), m.getTimeStamp());
			ArchivedMessageService.save(aMessage);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("ChatRoom Archived");
	}
}
