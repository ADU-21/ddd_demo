package com.adu21.ddd.policy.domain.service;

import com.adu21.ddd.exception.InvalidQuotationException;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.policy.mapper.HomePolicyMapper;
import com.adu21.ddd.policy.mapper.HomePolicyToQuotationMapper;
import com.adu21.ddd.policy.repository.HomePolicyRepository;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quote.domain.service.QuoteCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyFactoryService {

    @Autowired
    private QuoteCalculator quoteCalculator;

    @Autowired
    private HomePolicyRepository homePolicyRepository;
    private HomePolicyToQuotationMapper homePolicyToQuotationMapper = new HomePolicyToQuotationMapper();
    private HomePolicyMapper homePolicyMapper = new HomePolicyMapper();

    public String createPolicy(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = homePolicyMapper.map(command, HomePolicy.class);
        HomePolicyQuotation homePolicyQuotation = homePolicyToQuotationMapper.map(command, HomePolicyQuotation.class);
        checkPolicyPremium(homePolicyQuotation);
        homePolicyRepository.save(homePolicy);
        return homePolicy.getPolicyNumber();
    }

    private void checkPolicyPremium(HomePolicyQuotation homePolicyQuotation) {
        if (!homePolicyQuotation.getPremium().equals(quoteCalculator.calculate(homePolicyQuotation)))
            throw new InvalidQuotationException();
    }
}
