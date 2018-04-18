package com.adu21.ddd.policy.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;

public class CarPolicyToQuotationMapper extends BaseMapper {
    public CarPolicyToQuotationMapper() {
        classMap(CreateCarPolicyCommand.class, CarPolicyQuotation.class)
                .byDefault()
                .register();
    }
}
