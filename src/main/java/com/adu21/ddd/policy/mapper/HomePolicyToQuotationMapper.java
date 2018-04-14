package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.mapper.BaseMapper;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;

public class HomePolicyToQuotationMapper extends BaseMapper {
    public HomePolicyToQuotationMapper() {
        classMap(CreateHomePolicyCommand.class, HomePolicyQuotation.class)
                .byDefault()
                .register();
    }
}
