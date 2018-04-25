package com.adu21.ddd.policy.domain.service;

import com.adu21.ddd.quotation.exception.InvalidQuotationException;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.policy.mapper.CarPolicyMapper;
import com.adu21.ddd.policy.mapper.HomePolicyMapper;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import com.adu21.ddd.policy.repository.HomePolicyRepository;
import com.adu21.ddd.quotation.repository.CarPolicyQuotationRepository;
import com.adu21.ddd.quotation.repository.HomePolicyQuotationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyFactoryService {

    @Autowired
    private HomePolicyRepository homePolicyRepository;
    private HomePolicyMapper homePolicyMapper = new HomePolicyMapper();

    @Autowired
    private HomePolicyQuotationRepository homePolicyQuotationRepository;

    @Autowired
    private CarPolicyRepository carPolicyRepository;
    private CarPolicyMapper carPolicyMapper = new CarPolicyMapper();

    @Autowired
    private CarPolicyQuotationRepository carPolicyQuotationRepository;

    public HomePolicy createPolicy(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = homePolicyMapper.map(command, HomePolicy.class);
        if (!homePolicyQuotationRepository.existsByQuoteId(homePolicy.getQuoteId()))
            throw new InvalidQuotationException();
        homePolicyRepository.save(homePolicy);
        return homePolicy;
    }

    public CarPolicy createPolicy(CreateCarPolicyCommand command) {
        CarPolicy carPolicy = carPolicyMapper.map(command, CarPolicy.class);
        if (!carPolicyQuotationRepository.existsByQuoteId(carPolicy.getQuoteId()))
            throw new InvalidQuotationException();
        carPolicyRepository.save(carPolicy);
        return carPolicy;
    }
}
