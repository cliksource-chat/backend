package com.collabera.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.models.ArchivedMessages;
import com.collabera.archive_models.Messages_Archive;
import com.collabera.archive_repositories.ArchivedMessagesRepository;

@RestController
public class ArchivedMessageController {
	
	@Autowired
	ArchivedMessagesRepository ArchivedMessageService;
	
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/archived/messages")
	public List<Messages_Archive> getMessages(){
		return ArchivedMessageService.findAll();
	}
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/archived/messages/{id}")
	public Messages_Archive getMessage(@PathVariable String id) {
		Optional<Messages_Archive> temp = ArchivedMessageService.findByMongoId(id);
		if(temp.isPresent()) {
			return temp.get();
		}else {
			return null;
		}
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/api/archived/messages/byRoomId/{chatRoomId}")
	public List<Messages_Archive> getArchivedMessagesById(@PathVariable String chatRoomId){
		List<Messages_Archive> temp = ArchivedMessageService.findByChatroomOrderByTimestampAsc(chatRoomId);
		if(temp.isEmpty()) {
			return null;
		}else {
			return temp;
		}
	}
	
	@CrossOrigin(origins = "localhost:4200")
	@PostMapping("/api/archived/messages")
	public ResponseEntity<String> postArchivedMessage(@RequestBody Messages_Archive message){
		message.setTimestamp(new Date());
		ArchivedMessageService.save(message);
		return ResponseEntity.ok("MESSAGE CREATED");
	}

}
