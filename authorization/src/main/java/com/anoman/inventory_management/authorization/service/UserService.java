package com.anoman.inventory_management.authorization.service;

import java.util.Optional;

import com.anoman.inventory_management.authorization.model.User;

public interface UserService {

	Optional<User> findByUsername(String username);
}
