package com.adu21.ddd.controller.rest;

import com.adu21.ddd.contract.UserResponseVO;
import com.adu21.ddd.model.User;
import com.adu21.ddd.service.UserService;
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
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)  // 不需要动作 restful 设计原则
    public ResponseEntity<UserResponseVO> register(@RequestBody Map<String, String> requestBody) {
        User user = new User();
        UserResponseVO response = new UserResponseVO();
        user.setEmail(requestBody.get("email"));
        user.setUserName(requestBody.get("username"));

        String token = UUID.randomUUID().toString();
        user.setToken(token);

        response.setSuccess(!userService.userExist(user) && userService.saveUser(user));
        response.setToken(token);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/password", method = RequestMethod.POST)
    public boolean setPassword(@RequestBody Map<String, String> requestBody) {
        try {
            User user = userService.findUserByToken(requestBody.get("token"));
            user.setPassWord(requestBody.get("password"));
            userService.saveUser(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestBody Map<String, String> requestBody){
        if(!userService.userNameExist(requestBody.get("username"))){
            return false;
        }
        User user = userService.findUserByName(requestBody.get("username"));
        return userService.verifyPassword(user, requestBody.get("password"));
    }

}
