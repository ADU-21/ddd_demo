package com.adu21.ddd.quotation.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.quotation.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;

public class CarPolicyQuotationMapper extends BaseMapper {
    public CarPolicyQuotationMapper() {
        classMap(EnquiryCarPolicyCommand.class, CarPolicyQuotation.class)
                .byDefault()
                .register();
    }
}
