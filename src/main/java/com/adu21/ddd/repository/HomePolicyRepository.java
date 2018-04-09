package com.adu21.ddd.repository;

import com.adu21.ddd.model.HomePolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HomePolicyRepository extends CrudRepository<HomePolicy, Long> {
    boolean existsByPolicyNumber(int policyNumber);

    HomePolicy getByPolicyNumber(int PolicyNumber);
}
