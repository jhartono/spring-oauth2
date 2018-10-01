package com.anoman.inventory_management.resource.mapper;

import com.anoman.inventory_management.resource.domain.User;
import com.anoman.inventory_management.resource.dto.UserDto;

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
