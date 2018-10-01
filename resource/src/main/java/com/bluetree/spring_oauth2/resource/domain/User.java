package com.bluetree.spring_oauth2.resource.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User extends AuditableModel {

	private static final long serialVersionUID = -1785424797018802772L;

	@Column(name = "username", nullable = false, unique = true, length = 50)
	private String username;

	@Column(name = "password", nullable = false, length = 64)
	private String password;

	@Column(name = "enabled", nullable = false)
	private boolean enabled;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "user_authority", joinColumns = @JoinColumn(name="user_id"))
	@Column(name = "authority")
	private Set<String> authorities = new HashSet<String>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<String> authorities) {
		this.authorities = authorities;
	}
}
