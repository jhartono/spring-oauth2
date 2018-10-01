package com.bluetree.spring_oauth2.resource.domain;

import java.util.Date;

public interface Auditable {

	Date getCreatedDate();
	
	String getCreatedBy();
	
	Date getLastModifiedDate();
	
	String getLastModifiedBy();
	
	void setCreatedDate(Date createdDate);
	
	void setCreatedBy(String createdBy);
	
	void setLastModifiedDate(Date lastModifiedDate);
	
	void setLastModifiedBy(String lastModifiedBy);
}
