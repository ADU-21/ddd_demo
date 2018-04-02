package com.adu21.ddd.service;

import com.adu21.ddd.domain.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExsit(String userName, String email) {
        return userRepository.findByUserName(userName).size() > 0 ||
                userRepository.findByEmail(email).size() > 0;
    }

    public boolean saveUser(String userName, String email) {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        userRepository.save(user);
        return true;
    }
}
