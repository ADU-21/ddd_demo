package com.adu21.ddd.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adu21.ddd.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);

    User findByEmail(String email);

    User findById(int id);
}
