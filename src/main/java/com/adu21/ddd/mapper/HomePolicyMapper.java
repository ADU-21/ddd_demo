package com.adu21.ddd.mapper;

import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.HomePolicy;

public class HomePolicyMapper extends BaseMapper {
    public HomePolicyMapper() {
        classMap(CreateHomePolicyCommand.class, HomePolicy.class)
                .byDefault()
                .register();
    }
}
