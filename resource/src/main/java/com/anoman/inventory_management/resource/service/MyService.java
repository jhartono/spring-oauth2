package com.anoman.inventory_management.resource.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.anoman.inventory_management.resource.domain.Model;

public interface MyService<T extends Model, ID> {
	
	Optional<T> findOne(final ID id);

    List<T> findAll();
    
    List<T> findAll(Example<T> example);
    
    List<T> findAll(Specification<T> specification);
    
    Page<T> findPaginated(Example<T> example, int page, int size);
    
    Page<T> findAll(Pageable pageRequest);

    Page<T> findPaginated(int page, int size);

    T create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final ID entityId);
}
