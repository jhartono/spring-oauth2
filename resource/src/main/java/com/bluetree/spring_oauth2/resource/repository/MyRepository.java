package com.bluetree.spring_oauth2.resource.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import com.bluetree.spring_oauth2.resource.domain.Model;

@NoRepositoryBean
public interface MyRepository<T extends Model, ID> extends JpaRepository<T, ID>, 
			JpaSpecificationExecutor<T> {

}
