package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;


@NoRepositoryBean
public interface PolicyBaseRepository<T extends Policy> extends CrudRepository<T, Long> {
    Optional<T> findByPolicyNumber(String PolicyNumber);
}
