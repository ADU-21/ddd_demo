package com.adu21.ddd.quote;

import com.adu21.ddd.quote.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quote.domain.service.QuoteCalculator;
import com.adu21.ddd.quote.mapper.CarPolicyQuoteMapper;
import com.adu21.ddd.quote.mapper.HomePolicyQuoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteApplicationService {

    private HomePolicyQuoteMapper homePolicyQuoteMapper = new HomePolicyQuoteMapper();
    private CarPolicyQuoteMapper carPolicyQuoteMapper = new CarPolicyQuoteMapper();

    @Autowired
    private QuoteCalculator quoteCalculator;

    public HomePolicyQuotation calculateQuote(EnquiryHomePolicyCommand command) {
        // response re-input is some field is empty
        HomePolicyQuotation homePolicyQuotation = homePolicyQuoteMapper.map(command, HomePolicyQuotation.class);
        homePolicyQuotation.setPremium(quoteCalculator.calculate(homePolicyQuotation));
        return homePolicyQuotation;
    }

    public CarPolicyQuotation calculateQuote(EnquiryCarPolicyCommand command) {
        CarPolicyQuotation carPolicyQuotation = carPolicyQuoteMapper.map(command, CarPolicyQuotation.class);
        carPolicyQuotation.setPremium(quoteCalculator.calculate(carPolicyQuotation));
        return carPolicyQuotation;
    }
}
