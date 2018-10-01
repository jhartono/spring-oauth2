package com.anoman.inventory_management.resource.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anoman.inventory_management.resource.domain.User;
import com.anoman.inventory_management.resource.repository.MyRepository;
import com.anoman.inventory_management.resource.repository.UserRepository;
import com.anoman.inventory_management.resource.service.UserService;

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
