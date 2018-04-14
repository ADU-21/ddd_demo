package com.adu21.ddd.policy;

import com.adu21.ddd.policy.command.CreateCarPolicyCommand;
import com.adu21.ddd.policy.command.CreateHomePolicyCommand;
import com.adu21.ddd.policy.domain.model.CarPolicy;
import com.adu21.ddd.policy.domain.model.HomePolicy;
import com.adu21.ddd.policy.mapper.HomePolicyMapper;
import com.adu21.ddd.policy.repository.CarPolicyRepository;
import com.adu21.ddd.policy.repository.HomePolicyRepository;
import com.adu21.ddd.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyApplicationService {

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    @Autowired
    private CarPolicyRepository carPolicyRepository;

    @Autowired
    private UserRepository userRepository;
    private HomePolicyMapper homePolicyMapper = new HomePolicyMapper();

    public String create(CreateHomePolicyCommand command) {
        HomePolicy homePolicy = homePolicyMapper.map(command, HomePolicy.class);
        homePolicyRepository.save(homePolicy);
        return homePolicy.getPolicyNumber();
    }

    public void apply(CreateCarPolicyCommand createCarPolicyCommand) {
        CarPolicy carPolicy = new CarPolicy();
        carPolicyRepository.save(carPolicy);
    }
}
