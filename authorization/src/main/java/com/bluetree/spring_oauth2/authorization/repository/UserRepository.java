package com.bluetree.spring_oauth2.authorization.repository;

import com.bluetree.spring_oauth2.authorization.model.User;

public interface UserRepository {
	
	User findByUsername(String username);
}
