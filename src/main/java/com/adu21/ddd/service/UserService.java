package com.adu21.ddd.service;

import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExist(User user) {
        return userRepository.findByUserName(user.getUserName()).size() > 0 ||
                userRepository.findByEmail(user.getEmail()).size() > 0;
    }

    public boolean saveUser(User user) {
        userRepository.save(user);
        return true;
    }

    public User findUserByToken(String token) {
        return userRepository.findByToken(token).get(0);
    }

    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName).get(0);
    }

    public boolean verifyPassword(User user, String password) {
        user = this.findUserByName(user.getUserName());
        if(user == null){
            return false;
        }
        return user.getPassWord().equals(password);
    }

    public boolean userNameExist(String username) {
        return userRepository.findByUserName(username).size() != 0;
    }
}
