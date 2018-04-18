package com.adu21.ddd.quotation.domain.service;

import com.adu21.ddd.quotation.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quotation.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quotation.mapper.CarPolicyQuotationMapper;
import com.adu21.ddd.quotation.mapper.HomePolicyQuotationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {

    private HomePolicyQuotationMapper homePolicyQuotationMapper = new HomePolicyQuotationMapper();
    private CarPolicyQuotationMapper carPolicyQuotationMapper = new CarPolicyQuotationMapper();

    @Autowired
    private QuoteCalculator quoteCalculator;

    public HomePolicyQuotation createQuotation(EnquiryHomePolicyCommand command) {
        HomePolicyQuotation homePolicyQuotation = homePolicyQuotationMapper.map(command, HomePolicyQuotation.class);
        homePolicyQuotation.setPremium(quoteCalculator.calculate(homePolicyQuotation));
        return homePolicyQuotation;
    }

    public CarPolicyQuotation createQuotation(EnquiryCarPolicyCommand command) {
        CarPolicyQuotation carPolicyQuotation = carPolicyQuotationMapper.map(command, CarPolicyQuotation.class);
        carPolicyQuotation.setPremium(quoteCalculator.calculate(carPolicyQuotation));
        return carPolicyQuotation;
    }
}
