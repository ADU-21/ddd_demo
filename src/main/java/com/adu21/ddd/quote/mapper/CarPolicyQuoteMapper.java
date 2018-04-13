package com.adu21.ddd.quote.mapper;

import com.adu21.ddd.mapper.BaseMapper;
import com.adu21.ddd.quote.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;

public class CarPolicyQuoteMapper extends BaseMapper {
    public CarPolicyQuoteMapper() {
        classMap(EnquiryCarPolicyCommand.class, CarPolicyQuotation.class)
                .byDefault()
                .register();
    }
}
