package com.collabera.controllers;

import java.util.Arrays;
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

import com.collabera.models.Users;
import com.collabera.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository UserService;
	
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/users")
	public List<Users> getUsers(){
		//return UserService.findAll();
		//System.out.println(Arrays.toString(UserService.findAll().toArray()));
		return UserService.findAll();
		
	}
	@CrossOrigin(origins = "localhost:4200")
	@GetMapping("/api/users/{id}")
	public Users getUser(@PathVariable ObjectId id) {
		Optional<Users> temp = UserService.findById(id);
		if(temp.isPresent()) {
			return temp.get();
		} else {
			return null;
		}
	}
	@CrossOrigin(origins = "localhost:4200")
	@PostMapping("/api/users")
	public ResponseEntity<String> addUser(@RequestBody Users newUser){
		UserService.save(newUser);
		return ResponseEntity.status(200).body("Created!");
	}
	

}