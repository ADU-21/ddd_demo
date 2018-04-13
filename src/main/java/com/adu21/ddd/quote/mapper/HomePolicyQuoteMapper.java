package com.adu21.ddd.quote.mapper;

import com.adu21.ddd.mapper.BaseMapper;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;

public class HomePolicyQuoteMapper extends BaseMapper {
    public HomePolicyQuoteMapper() {
        classMap(EnquiryHomePolicyCommand.class, HomePolicyQuotation.class)
                .byDefault()
                .register();
    }
}
