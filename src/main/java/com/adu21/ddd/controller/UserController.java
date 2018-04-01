package com.adu21.ddd.controller;

import com.adu21.ddd.domain.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/${api.version}/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestParam String name, @RequestParam String pwd){
        User user = new User();
        user.setUserName(name);
        user.setPassWord(pwd);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
