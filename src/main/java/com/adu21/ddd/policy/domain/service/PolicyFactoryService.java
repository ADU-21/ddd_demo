package com.adu21.ddd.policy.domain.service;

import com.adu21.ddd.exception.InvalidQuotationException;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.policy.mapper.CarPolicyMapper;
import com.adu21.ddd.policy.mapper.CarPolicyToQuotationMapper;
import com.adu21.ddd.policy.mapper.HomePolicyMapper;
import com.adu21.ddd.policy.mapper.HomePolicyToQuotationMapper;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import com.adu21.ddd.policy.repository.HomePolicyRepository;
import com.adu21.ddd.quote.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quote.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quote.domain.service.QuoteCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyFactoryService {

    // This needs quote AR to calculate, dose that make sense？
    @Autowired
    private QuoteCalculator quoteCalculator;

    @Autowired
    private HomePolicyRepository homePolicyRepository;
    private HomePolicyMapper homePolicyMapper = new HomePolicyMapper();
    private HomePolicyToQuotationMapper homePolicyToQuotationMapper = new HomePolicyToQuotationMapper();

    @Autowired
    private CarPolicyRepository carPolicyRepository;
    private CarPolicyMapper carPolicyMapper = new CarPolicyMapper();
    private CarPolicyToQuotationMapper carPolicyToQuotationMapper = new CarPolicyToQuotationMapper();

    public String createPolicy(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = homePolicyMapper.map(command, HomePolicy.class);
        HomePolicyQuotation homePolicyQuotation = homePolicyToQuotationMapper.map(command, HomePolicyQuotation.class);
        checkPolicyPremium(homePolicyQuotation);
        homePolicyRepository.save(homePolicy);
        return homePolicy.getPolicyNumber();
    }

    public String createPolicy(CreateCarPolicyCommand command) {
        CarPolicy carPolicy = carPolicyMapper.map(command, CarPolicy.class);
        CarPolicyQuotation carPolicyQuotation = carPolicyToQuotationMapper.map(command, CarPolicyQuotation.class);
        checkPolicyPremium(carPolicyQuotation);
        carPolicyRepository.save(carPolicy);
        return carPolicy.getPolicyNumber();
    }

    private void checkPolicyPremium(HomePolicyQuotation homePolicyQuotation) {
        if (!homePolicyQuotation.getPremium().equals(quoteCalculator.calculate(homePolicyQuotation)))
            throw new InvalidQuotationException();
    }

    private void checkPolicyPremium(CarPolicyQuotation carPolicyQuotation) {
        if (!carPolicyQuotation.getPremium().equals(quoteCalculator.calculate(carPolicyQuotation)))
            throw new InvalidQuotationException();
    }
}
