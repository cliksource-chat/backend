package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.ArchivedMessages;

public interface ArchivedMessagesRepository extends MongoRepository<ArchivedMessages, String> {

	public List<ArchivedMessages> findAll();
	public Optional<ArchivedMessages> findById(ObjectId id);
	public List<ArchivedMessages> findByChatRoomsId(ObjectId id);
	public List<ArchivedMessages> findByChatRoomsIdOrderByTimestampAsc(ObjectId id);
}
