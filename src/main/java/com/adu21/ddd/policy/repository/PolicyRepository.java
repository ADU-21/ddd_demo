package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.Policy;

import javax.transaction.Transactional;

@Transactional
public interface PolicyRepository extends PolicyBaseRepository<Policy> {
}
