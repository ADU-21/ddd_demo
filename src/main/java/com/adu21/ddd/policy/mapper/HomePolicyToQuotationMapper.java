package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;

public class HomePolicyToQuotationMapper extends BaseMapper {
    public HomePolicyToQuotationMapper() {
        classMap(CreateHomePolicyCommand.class, HomePolicyQuotation.class)
                .byDefault()
                .register();
    }
}
