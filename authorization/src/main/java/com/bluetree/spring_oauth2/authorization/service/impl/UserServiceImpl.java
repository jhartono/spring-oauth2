package com.bluetree.spring_oauth2.authorization.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bluetree.spring_oauth2.authorization.model.User;
import com.bluetree.spring_oauth2.authorization.repository.UserRepository;
import com.bluetree.spring_oauth2.authorization.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
        super();
    }

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findByUsername(String username) {
		return Optional.ofNullable(userRepository.findByUsername(username));
	}
}
