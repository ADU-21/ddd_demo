package com.adu21.ddd.policy.repository;

import com.adu21.ddd.policy.domain.model.CarPolicy;
import org.springframework.stereotype.Repository;


//public interface CarPolicyRepository extends CrudRepository<CarPolicy, Long> {
@Repository
public class CarPolicyRepository {
    public void save(CarPolicy carPolicy) {
    }
}
