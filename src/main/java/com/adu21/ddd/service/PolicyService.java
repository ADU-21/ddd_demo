package com.adu21.ddd.service;

import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.contract.UserRegisterResponseVO;
import com.adu21.ddd.model.Policy;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.PolicyRepository;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;
    @Autowired
    private UserRepository userRepository;


    public boolean verifyPolicyNumber(UserRegisterRequestVO userRequest) {
        return (policyRepository.existsByPolicyNumber(userRequest.getPolicyNumber()) &&
                policyRepository.getByPolicyNumber(userRequest.getPolicyNumber()).getEmail().equals(userRequest.getEmail()))
                || userRepository.existsByEmail(userRequest.getEmail());
    }
}
