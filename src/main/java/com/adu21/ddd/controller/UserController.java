package com.adu21.ddd.controller;

import com.adu21.ddd.domain.RegisterResponseVO;
import com.adu21.ddd.domain.User;
import com.adu21.ddd.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImp userServiceImp;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<RegisterResponseVO> register(@RequestBody Map<String, String> requestBody) {
        User user = new User();
        RegisterResponseVO response = new RegisterResponseVO();
        user.setEmail(requestBody.get("email"));
        user.setUserName(requestBody.get("username"));

        String token = UUID.randomUUID().toString();
        user.setToken(token);

        response.setSuccess(!userServiceImp.userExist(user) && userServiceImp.saveUser(user));
        response.setToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public boolean setPassword(@RequestBody Map<String, String> requestBody) {
        User user = userServiceImp.findUserByToken(requestBody.get("token"));
        user.setPassWord(requestBody.get("password"));
        userServiceImp.saveUser(user);
        return true;
    }
}
