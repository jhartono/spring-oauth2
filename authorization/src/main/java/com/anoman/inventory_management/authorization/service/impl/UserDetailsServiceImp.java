package com.anoman.inventory_management.authorization.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.anoman.inventory_management.authorization.model.User;
import com.anoman.inventory_management.authorization.service.UserService;

@Service("userDetailsService")
public class UserDetailsServiceImp implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userService.findByUsername(username);
		return user.map((u) -> {
			UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
	    	builder.disabled(!u.isEnabled());
	    	builder.password(u.getPassword());
	    	String[] authorities = u.getAuthorities().stream().toArray(String[]::new);
	    	builder.authorities(authorities);
	    	
	    	return builder.build();
		}).orElseThrow(() -> {
	    	throw new UsernameNotFoundException("User not found.");
		});
	}
}
