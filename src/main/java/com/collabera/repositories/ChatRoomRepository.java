package com.collabera.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.ChatRooms;

public interface ChatRoomRepository extends MongoRepository<ChatRooms, String> {

	public List<ChatRooms> findAll();
	
	public ChatRooms findById(ObjectId id);
}
