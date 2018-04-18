package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;

public class CarPolicyMapper extends BaseMapper {
    public CarPolicyMapper() {
        classMap(CreateCarPolicyCommand.class, CarPolicy.class)
                .field("holderName", "policyHolder.name")
                .field("holderEmail", "policyHolder.email")
                .field("holderId", "policyHolder.id")
                .field("holderBirthday", "policyHolder.birthDay")
                .byDefault()
                .register();
    }
}
