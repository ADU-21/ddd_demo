package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.HomePolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Transactional
public interface HomePolicyRepository extends PolicyBaseRepository<HomePolicy> {
}
