package com.bluetree.spring_oauth2.resource.repository;

import org.springframework.stereotype.Repository;

import com.bluetree.spring_oauth2.resource.domain.User;

@Repository
public interface UserRepository extends MyRepository<User, Long> {

}
