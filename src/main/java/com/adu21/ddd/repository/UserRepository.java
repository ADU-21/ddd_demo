package com.adu21.ddd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adu21.ddd.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUuid(String uuid);
    User findByUuid(String uuid);
}
