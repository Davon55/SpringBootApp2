package com.gcu.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gcu.model.UserEntity;

public interface UsersRepository extends CrudRepository<UserEntity, Integer> {
	List<UserEntity> findByFirstNameContainingIgnoreCase(String searchTerm);

}
