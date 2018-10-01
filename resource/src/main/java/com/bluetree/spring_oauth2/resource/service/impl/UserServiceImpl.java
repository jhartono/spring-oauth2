package com.bluetree.spring_oauth2.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetree.spring_oauth2.resource.domain.User;
import com.bluetree.spring_oauth2.resource.repository.MyRepository;
import com.bluetree.spring_oauth2.resource.repository.UserRepository;
import com.bluetree.spring_oauth2.resource.service.UserService;

@Service
public class UserServiceImpl extends AbstractService<User, Long> implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserServiceImpl() {
        super();
    }

	@Override
	protected MyRepository<User, Long> getRepository() {
		return this.userRepository;
	}

}
