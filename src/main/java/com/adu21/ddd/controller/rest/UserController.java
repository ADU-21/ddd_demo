package com.adu21.ddd.controller.rest;

import static org.springframework.http.HttpStatus.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.adu21.ddd.contract.UserRequestVO;
import com.adu21.ddd.contract.UserResponseVO;
import com.adu21.ddd.exception.TokenInvalidException;
import com.adu21.ddd.exception.UserExistException;
import com.adu21.ddd.exception.WrongPasswordException;
import com.adu21.ddd.model.User;
import com.adu21.ddd.service.UserService;

@RestController
@RequestMapping("/api/${api.version}")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @PostMapping(value = "/user")
    @ResponseStatus(CREATED)
    public UserResponseVO createUser(@RequestBody UserRequestVO userRequest) {
        User user = userService.createUser(userRequest);
        if (userService.userExist(user)) throw new UserExistException();
        return userService.saveUser(user);
    }

    @CrossOrigin
    @PutMapping(value = "/user/{userId}/password")
    @ResponseStatus(ACCEPTED)
    public void resetPassword(@PathVariable String userId, @RequestBody UserRequestVO userRequest) {
        User user = userService.findUserById(Integer.parseInt(userId));
        if (!user.getToken().equals(userRequest.getToken())) throw new TokenInvalidException();
        user.setPassWord(userRequest.getPassword());
        userService.saveUser(user);
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    @ResponseStatus(FOUND)
    public void login(@RequestBody UserRequestVO userRequest) {
        if (!userService.verifyPassword(userRequest)) throw new WrongPasswordException();
    }
}
