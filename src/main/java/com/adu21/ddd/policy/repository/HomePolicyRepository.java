package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.HomePolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomePolicyRepository extends CrudRepository<HomePolicy, Long> {
}
