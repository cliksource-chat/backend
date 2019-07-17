package com.collabera.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.collabera.models.Users;

public interface UserRepository extends MongoRepository<Users, String> {
	
	Users findById(ObjectId id);
	
	List<Users> findAll();

}
