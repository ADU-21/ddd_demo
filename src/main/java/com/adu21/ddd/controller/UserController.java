package com.adu21.ddd.controller;

import com.adu21.ddd.domain.User;
import com.adu21.ddd.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Map<String, String> requestBody) {
        User user = new User();
        user.setEmail(requestBody.get("email"));
        user.setUserName(requestBody.get("username"));
        return (!userServiceImp.userExist(user) && userServiceImp.saveUser(user));
    }
}
