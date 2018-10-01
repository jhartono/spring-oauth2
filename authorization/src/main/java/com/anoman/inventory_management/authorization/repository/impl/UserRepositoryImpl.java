package com.anoman.inventory_management.authorization.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.anoman.inventory_management.authorization.model.User;
import com.anoman.inventory_management.authorization.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public User findByUsername(String username) {
		String sql = "select u.id, u.username, u.password, u.enabled, a.authority from user u "
				+ "left outer join user_authority a on a.user_id = u.id "
				+ "where u.username = ? ";
		
		UserMapper mapper = new UserMapper();
		try {
			jdbcTemplate.queryForObject(sql, new Object[] { username }, mapper);
		} catch (IncorrectResultSizeDataAccessException e) {
			return null;
		}
		return mapper.getUser();
	}

}

class UserMapper implements RowMapper<User> {
	
	private User user;

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		if (user == null) {
			this.user = new User ();
			user.setId(rs.getLong("id"));
			user.setUsername(rs.getString("username"));
			user.setPassword(rs.getString("password"));
			user.setEnabled(rs.getBoolean("enabled"));
		}
		
		String authority = rs.getString("authority");
		if (!StringUtils.isEmpty(authority)) {
			user.getAuthorities().add(authority);
		}
		return null;
	}

	public final User getUser() {
		return user;
	}
	
}