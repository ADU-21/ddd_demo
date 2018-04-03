package com.adu21.ddd.service;

import com.adu21.ddd.contract.UserRequestVO;
import com.adu21.ddd.contract.UserResponseVO;
import com.adu21.ddd.model.User;
import com.adu21.ddd.repository.UserRepository;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean userExist(User user) {
        return userRepository.findByUserName(user.getUserName()) != null ||
                userRepository.findByEmail(user.getEmail()) != null;
    }

    public User createUser(UserRequestVO userRequest) {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.classMap(UserRequestVO.class, User.class)
                .field("username", "userName")
                .byDefault()
                .register();
        MapperFacade mapper = mapperFactory.getMapperFacade();
        return mapper.map(userRequest, User.class);
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
