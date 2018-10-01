package com.anoman.inventory_management.resource.domain;

import java.io.Serializable;

public interface Persistable<ID> extends Serializable {
	
	ID getId();
	
	void setId(ID id);
	
}
