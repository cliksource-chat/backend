package com.collabera.controllers;

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

import com.collabera.models.Messages;
import com.collabera.repositories.MessagesRepository;

@RestController
public class MessageController {
	
	@Autowired
	MessagesRepository MessageService;
	
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/messages")
	public List<Messages> getMessages(){
		return MessageService.findAll();
	}
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/messages/{id}")
	public Messages getMessage(@PathVariable ObjectId id) {
		Optional<Messages> temp = MessageService.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		}else {
			return null;
		}
	}
	@CrossOrigin(origins = "localhost:4200")
	@PostMapping("/api/messages")
	public ResponseEntity<String> postMessage(@RequestBody Messages message){
		MessageService.save(message);
		return ResponseEntity.ok("MESSAGE CREATED");
	}

}
