package com.adu21.ddd.service;

import com.adu21.ddd.command.CreateCarPolicyCommand;
import com.adu21.ddd.command.CreateHomePolicyCommand;
import com.adu21.ddd.command.UserRegisterRequestCommand;
import com.adu21.ddd.model.CarPolicy;
import com.adu21.ddd.model.HomePolicy;
import com.adu21.ddd.repository.CarPolicyRepository;
import com.adu21.ddd.repository.HomePolicyRepository;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {

    @Autowired
    private HomePolicyRepository homePolicyRepository;

    @Autowired
    private CarPolicyRepository carPolicyRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean verifyPolicyNumber(UserRegisterRequestCommand userRequest) {
        return (homePolicyRepository.existsByPolicyNumber(Integer.valueOf(userRequest.getPolicyNumber())) &&
                homePolicyRepository.getByPolicyNumber(Integer.valueOf(userRequest.getPolicyNumber())).getOwnerEmail().equals(userRequest.getOwnerEmail()))
                || userRepository.existsByEmail(userRequest.getOwnerEmail());
    }

    public void apply(CreateHomePolicyCommand createHomePolicyCommand) {
        HomePolicy homePolicy = new HomePolicy();
        homePolicyRepository.save(homePolicy.apply(createHomePolicyCommand));
    }

    public void apply(CreateCarPolicyCommand createCarPolicyCommand) {
        CarPolicy carPolicy = new CarPolicy();
        carPolicyRepository.save(carPolicy.apply(createCarPolicyCommand));
    }
}
