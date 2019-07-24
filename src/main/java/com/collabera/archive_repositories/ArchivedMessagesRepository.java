package com.collabera.archive_repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.archive_models.Messages_Archive;

public interface ArchivedMessagesRepository extends JpaRepository<Messages_Archive, Integer> {
	public List<Messages_Archive> findAll();
	
	public Optional<Messages_Archive> findByMongoId(String mongoId);
	
	public List<Messages_Archive> findByChatroomOrderByTimestampAsc(String mongoId);
	
	
	
}
