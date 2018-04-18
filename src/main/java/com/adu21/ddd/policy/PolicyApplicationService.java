package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.policy.domain.service.PolicyFactoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

    private static Logger logger = LoggerFactory.getLogger(PolicyApplicationService.class);

    @Autowired
    private PolicyFactoryService policyFactoryService;

    public String createPolicy(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = policyFactoryService.createPolicy(command);
        logger.info("Create home policy [{}] success", homePolicy.getPolicyNumber());
        return homePolicy.getPolicyNumber();
    }

    public String createPolicy(CreateCarPolicyCommand command) {
        CarPolicy carPolicy = policyFactoryService.createPolicy(command);
        logger.info("Create home policy [{}] success", carPolicy.getPolicyNumber());
        return carPolicy.getPolicyNumber();
    }
}
