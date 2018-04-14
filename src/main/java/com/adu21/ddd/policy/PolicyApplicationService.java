package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.service.PolicyFactoryService;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

    @Autowired
    private PolicyFactoryService policyFactoryService;

    @Autowired
    private CarPolicyRepository carPolicyRepository;

    public String create(CreateHomePolicyCommand command) {
        return policyFactoryService.createPolicy(command);
    }

    public void apply(CreateCarPolicyCommand createCarPolicyCommand) {
        CarPolicy carPolicy = new CarPolicy();
        carPolicyRepository.save(carPolicy);
    }
}
