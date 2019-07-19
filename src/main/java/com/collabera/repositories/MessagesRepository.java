package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.Messages;

public interface MessagesRepository extends MongoRepository<Messages, String> {

	public List<Messages> findAll();
	public Optional<Messages> findById(ObjectId id);
	public List<Messages> deleteByChatRoomsId(ObjectId id);
	public List<Messages> findByChatRoomsIdOrderByTimestampAsc(ObjectId id);	
}
