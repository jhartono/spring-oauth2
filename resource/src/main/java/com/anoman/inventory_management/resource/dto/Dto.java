package com.anoman.inventory_management.resource.dto;

import com.anoman.inventory_management.resource.domain.Persistable;

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
