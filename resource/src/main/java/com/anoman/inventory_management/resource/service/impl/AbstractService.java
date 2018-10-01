package com.anoman.inventory_management.resource.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import com.anoman.inventory_management.resource.domain.Model;
import com.anoman.inventory_management.resource.repository.MyRepository;
import com.anoman.inventory_management.resource.service.MyService;

@Transactional
public abstract class AbstractService<T extends Model, ID> implements MyService<T, ID> {

	@Override
    @Transactional(readOnly = true)
	public Optional<T> findOne(ID id) {
    		return getRepository().findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<T> findAll() {
    		List<T> model = new ArrayList<T>();
    		getRepository().findAll().forEach(model::add);
    		return model;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<T> findPaginated(int page, int size) {
		return getRepository().findAll(PageRequest.of(page, size));
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll(Example<T> example) {
		return getRepository().findAll(example);
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<T> findAll(Specification<T> specification) {
		return getRepository().findAll(specification);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<T> findPaginated(Example<T> example, int page, int size) {
		return getRepository().findAll(example, 
				PageRequest.of(page, size));
	}
	
	@Override
    @Transactional(readOnly = true)
	public Page<T> findAll(Pageable pageRequest) {
    		return getRepository().findAll(pageRequest);
	}

	@Override
    public T create(final T entity) {
        return getRepository().save(entity);
    }

    @Override
    public T update(final T entity) {
        return getRepository().save(entity);
    }

    @Override
    public void delete(final T entity) {
    	getRepository().delete(entity);
    }

    @Override
    public void deleteById(final ID id) {
    	getRepository().deleteById(id);
    }
	
	protected abstract MyRepository<T, ID> getRepository();

}
