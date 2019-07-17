package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	
	Optional<Users> findById(ObjectId id);
	
	List<Users> findAll();

}
