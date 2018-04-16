package com.adu21.ddd.quotation;

import com.adu21.ddd.quotation.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quotation.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quotation.domain.service.QuoteCalculator;
import com.adu21.ddd.quotation.mapper.CarPolicyQuotationMapper;
import com.adu21.ddd.quotation.mapper.HomePolicyQuotationMapper;
import com.adu21.ddd.quotation.repository.CarPolicyQuotationRepository;
import com.adu21.ddd.quotation.repository.HomePolicyQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationApplicationService {

    private HomePolicyQuotationMapper homePolicyQuotationMapper = new HomePolicyQuotationMapper();
    private CarPolicyQuotationMapper carPolicyQuotationMapper = new CarPolicyQuotationMapper();

    @Autowired
    private QuoteCalculator quoteCalculator;

    @Autowired
    private HomePolicyQuotationRepository homePolicyQuotationRepository;

    @Autowired
    private CarPolicyQuotationRepository carPolicyQuotationRepository;

    public HomePolicyQuotation calculateQuote(EnquiryHomePolicyCommand command) {
        HomePolicyQuotation homePolicyQuotation = homePolicyQuotationMapper.map(command, HomePolicyQuotation.class);
        homePolicyQuotation.setPremium(quoteCalculator.calculate(homePolicyQuotation));
        homePolicyQuotationRepository.save(homePolicyQuotation);
        return homePolicyQuotation;
    }

    public CarPolicyQuotation calculateQuote(EnquiryCarPolicyCommand command) {
        CarPolicyQuotation carPolicyQuotation = carPolicyQuotationMapper.map(command, CarPolicyQuotation.class);
        carPolicyQuotation.setPremium(quoteCalculator.calculate(carPolicyQuotation));
        carPolicyQuotationRepository.save(carPolicyQuotation);
        return carPolicyQuotation;
    }
}
