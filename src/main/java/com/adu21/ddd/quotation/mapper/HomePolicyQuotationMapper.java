package com.adu21.ddd.quotation.mapper;

import com.adu21.ddd.common.BaseMapper;
import com.adu21.ddd.quotation.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;

public class HomePolicyQuotationMapper extends BaseMapper {
    public HomePolicyQuotationMapper() {
        classMap(EnquiryHomePolicyCommand.class, HomePolicyQuotation.class)
                .byDefault()
                .register();
    }
}
