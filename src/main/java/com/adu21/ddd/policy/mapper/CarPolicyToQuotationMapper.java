package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.mapper.BaseMapper;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.quote.domain.model.CarPolicyQuotation;

public class CarPolicyToQuotationMapper extends BaseMapper {
    public CarPolicyToQuotationMapper() {
        classMap(CreateCarPolicyCommand.class, CarPolicyQuotation.class)
                .byDefault()
                .register();
    }
}
