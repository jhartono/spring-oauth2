package com.bluetree.spring_oauth2.resource.dto;

import com.bluetree.spring_oauth2.resource.domain.Persistable;

public abstract class Dto implements Persistable<Long> {
	
	private static final long serialVersionUID = -5445040904040343641L;
	
	private Long id;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
