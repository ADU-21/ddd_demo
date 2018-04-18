package com.adu21.ddd.user.domain.service;

import com.adu21.ddd.exception.EmailExistException;
import com.adu21.ddd.exception.ErrorInputException;
import com.adu21.ddd.exception.PolicyNotExistException;
import com.adu21.ddd.policy.domain.model.Policy;
import com.adu21.ddd.policy.repository.PolicyRepository;
import com.adu21.ddd.user.UserRepository;
import com.adu21.ddd.user.domain.model.User;
import com.adu21.ddd.utils.EmailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RegisterService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PolicyRepository policyRepository;

    @Autowired
    EmailManager emailManager;

    public User createUser(String email, String policyNumber) {
        if (!isInputValidation(policyNumber, email)) throw new ErrorInputException();
        if (isEmailExist(email)) throw new EmailExistException();
        String uuid = UUID.randomUUID().toString();
        User user = new User(uuid, null, email);
        userRepository.save(user);
        emailManager.sendEmail(uuid);
        return user;
    }

    private boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    private boolean isInputValidation(String policyNumber, String email) {
        Policy policy = policyRepository.findByPolicyNumber(policyNumber).orElseThrow(PolicyNotExistException::new);
        return policy.getPolicyHolder().getEmail().equals(email) && !email.equals("") && !policyNumber.equals("");
    }
}
