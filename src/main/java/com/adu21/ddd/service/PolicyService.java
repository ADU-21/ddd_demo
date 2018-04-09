package com.adu21.ddd.service;

import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.model.HomePolicy;
import com.adu21.ddd.repository.HomePolicyRepository;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    private HomePolicyRepository homePolicyRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean verifyPolicyNumber(UserRegisterRequestVO userRequest) {
        return (homePolicyRepository.existsByPolicyNumber(Integer.valueOf(userRequest.getPolicyNumber())) &&
                homePolicyRepository.getByPolicyNumber(Integer.valueOf(userRequest.getPolicyNumber())).getOwnerEmail().equals(userRequest.getOwnerEmail()))
                || userRepository.existsByEmail(userRequest.getOwnerEmail());
    }

    public void apply(CreateHomePolicyCommand createHomePolicyCommand) {
        HomePolicy homePolicy = new HomePolicy();
        homePolicyRepository.save(homePolicy.apply(createHomePolicyCommand));
    }
}
