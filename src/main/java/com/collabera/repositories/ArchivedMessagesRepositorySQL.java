package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.models.ArchivedMessages_SQL;

public interface ArchivedMessagesRepositorySQL  extends JpaRepository<ArchivedMessages_SQL, String>{
	public List<ArchivedMessages_SQL> findAll();
	public Optional<ArchivedMessages_SQL> findById(String mongo_Id);
	public List<ArchivedMessages_SQL> findByChatRoomsId( String mongo_Id);
	public List<ArchivedMessages_SQL> findByChatRoomsIdOrderByTimestampAsc(String mongo_Id);
}
