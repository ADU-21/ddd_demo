package com.adu21.ddd.policy;

import com.adu21.ddd.mapper.InquiryToHomePolicyMapper;
import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.quote.command.EnquiryHomePolicyCommand;
import com.adu21.ddd.quote.domain.model.Quotation;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.quote.domain.service.QuoteCalculator;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import com.adu21.ddd.policy.repository.HomePolicyRepository;
import com.adu21.ddd.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

//    @Autowired
//    private QuoteCalculator quoteCalculator;

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    @Autowired
    private CarPolicyRepository carPolicyRepository;

    @Autowired
    private UserRepository userRepository;
    private InquiryToHomePolicyMapper inquiryToHomePolicyMapper = new InquiryToHomePolicyMapper();

    public Quotation inquiry(EnquiryHomePolicyCommand command) {
//        HomePolicy homePolicy = inquiryToHomePolicyMapper.map(command, HomePolicy.class);
//        Double premium = calculator.calculate();
        return new Quotation(10.11);
    }

    public void apply(CreateHomePolicyCommand createHomePolicyCommand) {
        HomePolicy homePolicy = new HomePolicy();
        homePolicyRepository.save(homePolicy);
    }

    public void apply(CreateCarPolicyCommand createCarPolicyCommand) {
        CarPolicy carPolicy = new CarPolicy();
        carPolicyRepository.save(carPolicy);
    }

}
