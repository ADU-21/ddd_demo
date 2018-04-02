package com.adu21.ddd.repository;

import com.adu21.ddd.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByUserName(String username);
    List<User> findByEmail(String email);
    List<User> findByToken(String token);
}
