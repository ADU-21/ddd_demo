package com.adu21.ddd.mapper;

import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.HomePolicy;

public class InquiryToHomePolicyMapper extends BaseMapper {
    public InquiryToHomePolicyMapper() {
        classMap(EnquiryHomePolicyCommand.class, HomePolicy.class)
                .byDefault()
                .register();
    }
}
