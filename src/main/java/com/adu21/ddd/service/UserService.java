package com.adu21.ddd.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adu21.ddd.contract.UserRequestVO;
import com.adu21.ddd.contract.UserResponseVO;
import com.adu21.ddd.mapper.UserMapper;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper = new UserMapper();

    public boolean userExist(User user) {
        return userRepository.findByUserName(user.getUserName()) != null ||
                userRepository.findByEmail(user.getEmail()) != null;
    }

    public User createUser(UserRequestVO userRequest) {
        return userMapper.map(userRequest, User.class);
    }

    public UserResponseVO saveUser(User user) {
        UserResponseVO userResponse = new UserResponseVO();
        String token = UUID.randomUUID().toString();
        user.setToken(token);
        userResponse.setToken(token);
        userRepository.save(user);
        userResponse.setId(user.getId());
        return userResponse;
    }

    public User findUserById(int id) {
        return userRepository.findById(id);
    }

    public User findUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public boolean verifyPassword(UserRequestVO userRequest) {
        User user = this.findUserByName(userRequest.getUsername());
        return user != null && userRequest.getPassword().equals(user.getPassWord());
    }
}
