package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.models.ChatRooms_Archived;

public interface ChatRoomRepositorySQL extends JpaRepository<ChatRooms_Archived, String> {

	public List<ChatRooms_Archived> findAll();
	
	public Optional<ChatRooms_Archived> findById(String Mongo_Id);
	
	public List<ChatRooms_Archived> findByUser1IdOrderByCreatedAsc(String Mongo_Id);
	public List<ChatRooms_Archived> findByUser2IdOrderByCreatedAsc(String Mongo_Id);
}