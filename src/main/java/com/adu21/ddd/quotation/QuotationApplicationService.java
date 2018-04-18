package com.adu21.ddd.quotation;

import com.adu21.ddd.quotation.command.EnquiryCarPolicyCommand;
import com.adu21.ddd.quotation.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quotation.domain.service.QuoteService;
import com.adu21.ddd.quotation.repository.CarPolicyQuotationRepository;
import com.adu21.ddd.quotation.repository.HomePolicyQuotationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuotationApplicationService {

    private static Logger logger = LoggerFactory.getLogger(QuotationApplicationService.class);

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private HomePolicyQuotationRepository homePolicyQuotationRepository;

    @Autowired
    private CarPolicyQuotationRepository carPolicyQuotationRepository;

    public HomePolicyQuotation calculateQuote(EnquiryHomePolicyCommand command) {
        HomePolicyQuotation homePolicyQuotation = quoteService.createQuotation(command);
        logger.info("Calculate home quote: [{}]", homePolicyQuotation.getQuoteId());
        homePolicyQuotationRepository.save(homePolicyQuotation);
        return homePolicyQuotation;
    }

    public CarPolicyQuotation calculateQuote(EnquiryCarPolicyCommand command) {
        CarPolicyQuotation carPolicyQuotation = quoteService.createQuotation(command);
        logger.info("Calculate car quote: [{}]", carPolicyQuotation.getQuoteId());
        carPolicyQuotationRepository.save(carPolicyQuotation);
        return carPolicyQuotation;
    }
}
