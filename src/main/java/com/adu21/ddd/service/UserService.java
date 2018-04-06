package com.adu21.ddd.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.contract.UserRegisterResponseVO;
import com.adu21.ddd.mapper.UserMapper;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
//    private UserMapper userMapper = new UserMapper();

//    public boolean userExist(User user) {
//        return userRepository.findByUserName(user.getPolicyNumber()) != null ||
//                userRepository.findByEmail(user.getEmail()) != null;
//    }

//    public User createUser(UserRegisterRequestVO userRequest) {
//        return userMapper.map(userRequest, User.class);
//    }

    public UserRegisterResponseVO saveUser(String email) {
        User user = new User();
        user.setEmail(email);
        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);
        userRepository.save(user);
        return new UserRegisterResponseVO(uuid);
    }

//    public User findUserById(int id) {
//        return userRepository.findById(id);
//    }
//
//    public User findUserByName(String userName) {
//        return userRepository.findByUserName(userName);
//    }

//    public boolean verifyPassword(UserRegisterRequestVO userRequest) {
//        User user = this.findUserByName(userRequest.getPolicyNumber());
//        return user != null && userRequest.getPassword().equals(user.getPassWord());
//    }
}
