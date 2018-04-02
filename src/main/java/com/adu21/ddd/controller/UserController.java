package com.adu21.ddd.controller;

import com.adu21.ddd.domain.User;
import com.adu21.ddd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody Map<String,String> requestBody){
        User user = new User();
        user.setUserName(requestBody.get("username"));
        user.setEmail(requestBody.get("email"));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
