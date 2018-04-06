package com.adu21.ddd.repository;

import com.adu21.ddd.model.Policy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.adu21.ddd.model.User;


@Repository
public interface PolicyRepository extends CrudRepository<Policy, Long> {
    boolean existsByPolicyNumber(String policyNumber);
    Policy getByPolicyNumber(String PolicyNumber);
}
