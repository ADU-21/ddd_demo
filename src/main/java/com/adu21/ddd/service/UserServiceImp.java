package com.adu21.ddd.service;

import com.adu21.ddd.domain.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean userExist(User user) {
        return userRepository.findByUserName(user.getUserName()).size() > 0 ||
                userRepository.findByEmail(user.getEmail()).size() > 0;
    }

    @Override
    public boolean saveUser(User user) {
        userRepository.save(user);
        return true;
    }
}
