package com.adu21.ddd.user.domain.service;

import com.adu21.ddd.user.exception.UserNotExistException;
import com.adu21.ddd.user.UserRepository;
import com.adu21.ddd.user.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public boolean login(String email, String password) {
        User user = userRepository.findByEmail(email).orElseThrow(UserNotExistException::new);
        return user.isPassWordCorrect(password);
    }
}
