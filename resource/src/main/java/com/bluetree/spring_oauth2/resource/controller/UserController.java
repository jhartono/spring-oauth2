package com.bluetree.spring_oauth2.resource.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bluetree.spring_oauth2.resource.dto.UserDto;
import com.bluetree.spring_oauth2.resource.mapper.UserToUserDtoMapper;
import com.bluetree.spring_oauth2.resource.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<UserDto> getUsers() {
		return userService.findAll().stream().map((user) -> {
			return UserToUserDtoMapper.mapModelToUserDto(user);
		}).collect(Collectors.toList());
	}
	
	@ResponseBody
	@RequestMapping(value = "/users/{user_id}", method = RequestMethod.GET)
	public UserDto getUser(@PathVariable("user_id") Long userId) {
		return userService.findOne(userId).map((user) -> {
			return UserToUserDtoMapper.mapModelToUserDto(user);
		}).orElse(new UserDto());
	}

}
