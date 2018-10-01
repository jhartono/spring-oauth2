package com.anoman.inventory_management.resource.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model implements Persistable<Long> {
	
	private static final long serialVersionUID = -9189109724804454885L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
