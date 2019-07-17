package com.collabera.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.collabera.models.Users;
import com.collabera.repositories.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository UserService;
	
	@GetMapping("/api/users")
	public List<Users> getUsers(){
		//return UserService.findAll();
		//System.out.println(Arrays.toString(UserService.findAll().toArray()));
		return UserService.findAll();
		
	}
	
	@PostMapping("/api/users")
	public ResponseEntity<String> addUser(@RequestBody Users newUser){
		UserService.save(newUser);
		return ResponseEntity.status(200).body("Created!");
	}
	

}