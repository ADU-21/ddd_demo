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
import com.adu21.ddd.quotation.domain.model.CarPolicyQuotation;
import com.adu21.ddd.quotation.domain.model.HomePolicyQuotation;
import com.adu21.ddd.quotation.domain.service.QuoteCalculator;
import com.adu21.ddd.quotation.repository.CarPolicyQuotationRepository;
import com.adu21.ddd.quotation.repository.HomePolicyQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyFactoryService {

    @Autowired
    private QuoteCalculator quoteCalculator;

    @Autowired
    private HomePolicyRepository homePolicyRepository;
    private HomePolicyMapper homePolicyMapper = new HomePolicyMapper();
    private HomePolicyToQuotationMapper homePolicyToQuotationMapper = new HomePolicyToQuotationMapper();

    @Autowired
    private HomePolicyQuotationRepository homePolicyQuotationRepository;

    @Autowired
    private CarPolicyRepository carPolicyRepository;
    private CarPolicyMapper carPolicyMapper = new CarPolicyMapper();
    private CarPolicyToQuotationMapper carPolicyToQuotationMapper = new CarPolicyToQuotationMapper();

    @Autowired
    private CarPolicyQuotationRepository carPolicyQuotationRepository;

    public HomePolicy createPolicy(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = homePolicyMapper.map(command, HomePolicy.class);
        HomePolicyQuotation homePolicyQuotation = homePolicyToQuotationMapper.map(command, HomePolicyQuotation.class);
        checkPolicyPremium(homePolicyQuotation);
        homePolicyRepository.save(homePolicy);
        return homePolicy;
    }

    public CarPolicy createPolicy(CreateCarPolicyCommand command) {
        CarPolicy carPolicy = carPolicyMapper.map(command, CarPolicy.class);
        CarPolicyQuotation carPolicyQuotation = carPolicyToQuotationMapper.map(command, CarPolicyQuotation.class);
        checkPolicyPremium(carPolicyQuotation);
        carPolicyRepository.save(carPolicy);
        return carPolicy;
    }

    private void checkPolicyPremium(HomePolicyQuotation homePolicyQuotation) {
        HomePolicyQuotation homePolicyQuotationInStore = homePolicyQuotationRepository.findByQuoteId(homePolicyQuotation.getQuoteId())
                .orElseThrow(InvalidQuotationException::new);
        Double premiumFromRequest = homePolicyQuotation.getPremium();
        Double premiumFromCalculate = quoteCalculator.calculate(homePolicyQuotation);
        Double premiumFromStore = homePolicyQuotationInStore.getPremium();
        //TODO: Refactor the command
        if (!(premiumFromRequest.equals(premiumFromCalculate) && premiumFromRequest.equals(premiumFromStore)))
            throw new InvalidQuotationException();
    }

    private void checkPolicyPremium(CarPolicyQuotation carPolicyQuotation) {
        CarPolicyQuotation carPolicyQuotationInStore = carPolicyQuotationRepository.findByQuoteId(carPolicyQuotation.getQuoteId())
                .orElseThrow(InvalidQuotationException::new);
        Double premiumFromRequest = carPolicyQuotation.getPremium();
        Double premiumFromCalculate = quoteCalculator.calculate(carPolicyQuotation);
        Double premiumFromStore = carPolicyQuotationInStore.getPremium();
        if (!(premiumFromRequest.equals(premiumFromCalculate) && premiumFromRequest.equals(premiumFromStore)))
            throw new InvalidQuotationException();
    }
}
