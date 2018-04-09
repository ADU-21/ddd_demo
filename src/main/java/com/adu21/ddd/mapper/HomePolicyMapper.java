package com.adu21.ddd.mapper;

import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.model.HomePolicy;

public class HomePolicyMapper extends BaseMapper {
    public HomePolicyMapper() {
        classMap(CreateHomePolicyCommand.class, HomePolicy.class)
                .byDefault()
                .register();
    }
}
