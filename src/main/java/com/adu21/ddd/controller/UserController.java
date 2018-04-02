package com.adu21.ddd.controller;

import com.adu21.ddd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody Map<String, String> requestBody) {
        return (!userService.userExsit(requestBody.get("username"), requestBody.get("email")) &&
                userService.saveUser(requestBody.get("username"), requestBody.get("email")));
    }
}
