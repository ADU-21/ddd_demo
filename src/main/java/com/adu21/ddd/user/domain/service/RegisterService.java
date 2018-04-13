package com.adu21.ddd.user.domain.service;

import com.adu21.ddd.exception.EmailExistException;
import com.adu21.ddd.exception.ErrorInputException;
import com.adu21.ddd.exception.PolicyNotExistException;
import com.adu21.ddd.policy.domain.model.PolicyEntity;
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

    public String registration(String email, String policyNumber) {
        if (!isInputValidation(policyNumber, email)) throw new ErrorInputException();
        if (isEmailExist(email)) throw new EmailExistException();
        String uuid = UUID.randomUUID().toString();
        userRepository.save(new User(uuid, null, email));
        emailManager.sendEmail(uuid);
        return uuid;
    }

    private boolean isEmailExist(String email) {
        return userRepository.existsByEmail(email);
    }

    private boolean isInputValidation(String policyNumber, String email) {
        PolicyEntity policyEntity = policyRepository.findByPolicyNumber(policyNumber).orElseThrow(PolicyNotExistException::new);
        return policyEntity.getOwnerEmail().equals(email) || !email.equals("") || !policyNumber.equals("");
    }
}
