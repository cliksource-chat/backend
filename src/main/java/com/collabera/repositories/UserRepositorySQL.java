package com.collabera.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.collabera.models.Users_Archived;

public interface UserRepositorySQL extends JpaRepository<Users_Archived, String> {
	
	Optional<Users_Archived> findById(String Mongo_Id);
	
	List<Users_Archived> findAll();
}