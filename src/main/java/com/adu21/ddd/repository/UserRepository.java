package com.adu21.ddd.repository;

import com.adu21.ddd.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByUserName(String userName);
    User findByEmail(String email);
    User findById(int id);
}
