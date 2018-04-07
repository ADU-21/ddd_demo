package com.adu21.ddd.repository;

import com.adu21.ddd.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    boolean existsByEmail(String email);

    boolean existsByUuid(String uuid);

    User findByUuid(String uuid);

    User findByEmail(String email);
}
