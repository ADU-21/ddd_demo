package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.service.PolicyFactoryService;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

    private static Logger logger = LoggerFactory.getLogger(PolicyApplicationService.class);

    @Autowired
    private PolicyFactoryService policyFactoryService;

    public String create(CreateHomePolicyCommand command) {
        logger.info("Create home policy with quote id [{}]", command.getQuoteId());
        return policyFactoryService.createPolicy(command);
    }

    public String create(CreateCarPolicyCommand command) {
        logger.info("Create car policy with quote id [{}]", command.getQuoteId());
        return policyFactoryService.createPolicy(command);
    }
}
