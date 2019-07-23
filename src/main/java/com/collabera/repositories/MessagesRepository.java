package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.collabera.models.Messages_Archived;

public interface MessagesRepository extends MongoRepository<Messages_Archived, String> {

	public List<Messages_Archived> findAll();
	public Optional<Messages_Archived> findById(String Mongo_Id);
	public List<Messages_Archived> deleteByChatRoomsId(String Mongo_Id);
	public List<Messages_Archived> findByChatRoomsIdOrderByTimestampAsc(String Mongo_Id);	
}
