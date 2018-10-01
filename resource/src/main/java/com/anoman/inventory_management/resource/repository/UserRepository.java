package com.anoman.inventory_management.resource.repository;

import org.springframework.stereotype.Repository;

import com.anoman.inventory_management.resource.domain.User;

@Repository
public interface UserRepository extends MyRepository<User, Long> {

}
