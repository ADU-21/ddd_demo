package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.PolicyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PolicyRepository extends CrudRepository<PolicyEntity, Long> {
    Optional<PolicyEntity> findByPolicyNumber(String PolicyNumber);
}
