package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.CarPolicy;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CarPolicyRepository extends PolicyBaseRepository<CarPolicy> {
}
