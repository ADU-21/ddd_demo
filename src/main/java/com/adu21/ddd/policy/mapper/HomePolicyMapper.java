package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.HomePolicy;

public class HomePolicyMapper extends BaseMapper {
    public HomePolicyMapper() {
        classMap(CreateHomePolicyCommand.class, HomePolicy.class)
                .field("holderName", "policyHolder.name")
                .field("holderEmail", "policyHolder.email")
                .field("holderId", "policyHolder.id")
                .field("holderBirthday", "policyHolder.birthDay")
                .byDefault()
                .register();
    }
}
