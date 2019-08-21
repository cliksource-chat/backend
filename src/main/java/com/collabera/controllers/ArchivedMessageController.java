package com.collabera.controllers;


import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.archive_repositories.ArchivedMessagesRepository;
import com.collabera.models.Messages;

@RestController
public class ArchivedMessageController {
	
	@Autowired
	ArchivedMessagesRepository MessageService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/messages/archive")
	public List<Messages> getMessages(){
		return MessageService.findAll();
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/messages/arhive/{id}")
	public Messages getMessage(@PathVariable ObjectId id) {
		Optional<Messages> temp = MessageService.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/messages/archive/byRoomId/{chatRoomId}")
	public List<Messages> getMessagesById(@PathVariable ObjectId chatRoomId){
		List<Messages> temp = MessageService.findByChatRoomsIdOrderByTimestampAsc(chatRoomId);
		if(temp.isEmpty()) {
			return null;
		}else {
			return temp;
		}
	}
}
