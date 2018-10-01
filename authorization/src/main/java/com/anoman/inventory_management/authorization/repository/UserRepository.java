package com.anoman.inventory_management.authorization.repository;

import com.anoman.inventory_management.authorization.model.User;

public interface UserRepository {
	
	User findByUsername(String username);
}
