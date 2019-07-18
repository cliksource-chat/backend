package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.ChatRooms;

public interface ChatRoomRepository extends MongoRepository<ChatRooms, String> {

	public List<ChatRooms> findAll();
	
	public Optional<ChatRooms> findById(ObjectId id);
	
	public List<ChatRooms> findByUser1IdOrderByCreatedAsc(ObjectId id);
	public List<ChatRooms> findByUser2IdOrderByCreatedAsc(ObjectId id);
	
}
