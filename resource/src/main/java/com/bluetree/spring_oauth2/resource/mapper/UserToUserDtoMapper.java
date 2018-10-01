package com.bluetree.spring_oauth2.resource.mapper;

import com.bluetree.spring_oauth2.resource.domain.User;
import com.bluetree.spring_oauth2.resource.dto.UserDto;

public class UserToUserDtoMapper {

	public static UserDto mapModelToUserDto(User user) {
		UserDto dto = new UserDto();
		dto.setId(user.getId());
		dto.setAuthorities(user.getAuthorities());
		dto.setEnabled(user.isEnabled());
		dto.setPassword(user.getPassword());
		dto.setUsername(user.getUsername());
		
		return dto;
	}
	
	public static User mapUserDtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setAuthorities(userDto.getAuthorities());
		user.setEnabled(userDto.isEnabled());
		user.setPassword(userDto.getPassword());
		user.setUsername(userDto.getUsername());
		
		return user;
	}
}
