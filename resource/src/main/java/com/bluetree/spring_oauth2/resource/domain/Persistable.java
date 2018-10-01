package com.bluetree.spring_oauth2.resource.domain;

import java.io.Serializable;

public interface Persistable<ID> extends Serializable {
	
	ID getId();
	
	void setId(ID id);
	
}
