package com.collabera.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.models.ChatRooms;
import com.collabera.repositories.ChatRoomRepository;

@RestController
public class ChatRoomController {
	
	@Autowired
	ChatRoomRepository ChatRoomService;
	
	@GetMapping("/api/chatrooms")
	public List<ChatRooms> getAllRooms(){
		return ChatRoomService.findAll();
	}
	
	@PostMapping("/api/chatrooms")
	public ResponseEntity<String> createRoom(@RequestBody ChatRooms newRoom){
		newRoom.setCreated(new Date());
		ChatRoomService.save(newRoom);
		
		return ResponseEntity.status(HttpStatus.CREATED).body("Created!");
	}
	
	

}
