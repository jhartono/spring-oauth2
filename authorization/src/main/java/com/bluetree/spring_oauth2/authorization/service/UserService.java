package com.bluetree.spring_oauth2.authorization.service;

import java.util.Optional;

import com.bluetree.spring_oauth2.authorization.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);
}
