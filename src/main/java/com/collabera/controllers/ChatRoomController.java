package com.collabera.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.models.ChatRooms;
import com.collabera.repositories.ChatRoomRepository;

@RestController
public class ChatRoomController {
	
	@Autowired
	ChatRoomRepository ChatRoomService;
	
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/chatrooms")
	public List<ChatRooms> getAllRooms(){
		return ChatRoomService.findAll();
	}
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/chatrooms/{id}")
	public ChatRooms getChatRoom(@PathVariable ObjectId id){
		Optional<ChatRooms> temp = ChatRoomService.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}
		return null;
	}
	@CrossOrigin(origins = "localhost:4200")
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
	@CrossOrigin(origins = "localhost:4200")
	@PostMapping("/api/chatrooms")
	public ResponseEntity<String> createRoom(@RequestBody ChatRooms newRoom){
		newRoom.setCreated(new Date());
		ChatRoomService.save(newRoom);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Created!");
	}
}
