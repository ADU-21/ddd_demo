package com.adu21.ddd.service;

import com.adu21.ddd.command.UserLoginRequestCommand;
import com.adu21.ddd.command.UserResponseCommand;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(String email) {
        User user = new User();
        user.setEmail(email);
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        return user;
    }

    public boolean verifyEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    public boolean userExist(String uuid) {
        return userRepository.existsByUuid(uuid);
    }

    public User findUserByUuid(String uuid) {
        return userRepository.findByUuid(uuid);
    }

    public UserResponseCommand saveUser(User user) {
        userRepository.save(user);
        return new UserResponseCommand(user.getUuid());
    }

    public boolean verifyEmailAndPassword(UserLoginRequestCommand userLoginRequestCommand) {
        User user = userRepository.findByEmail(userLoginRequestCommand.getEmail());
        return user != null && userLoginRequestCommand.getPassword().equals(user.getPassWord());
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
