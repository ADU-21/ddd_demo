package com.adu21.ddd.repository;

import com.adu21.ddd.model.CarPolicy;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CarPolicyRepository extends CrudRepository<CarPolicy, Long> {
}
