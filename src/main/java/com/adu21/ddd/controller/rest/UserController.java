package com.adu21.ddd.controller.rest;

import com.adu21.ddd.command.UserLoginRequestCommand;
import com.adu21.ddd.command.UserRegisterRequestCommand;
import com.adu21.ddd.command.UserResponseCommand;
import com.adu21.ddd.exception.EmailExistException;
import com.adu21.ddd.exception.ErrorInputException;
import com.adu21.ddd.exception.UserNotExistException;
import com.adu21.ddd.exception.LoginFailedException;
import com.adu21.ddd.model.User;
import com.adu21.ddd.service.PolicyService;
import com.adu21.ddd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api")
@Api(value = "User REST API", description = "User related API")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PolicyService policyService;

    @CrossOrigin
    @PostMapping(value = "/user")
    @ResponseStatus(CREATED)
    @ApiOperation(value = "POST", notes = "Create user")
    public UserResponseCommand createUser(@RequestBody UserRegisterRequestCommand userRequest) {
        if (!policyService.verifyPolicyNumber(userRequest) || userRequest.getOwnerEmail().equals("") ||
                userRequest.getPolicyNumber().equals("") ) throw new ErrorInputException();
        if (userService.verifyEmail(userRequest.getOwnerEmail())) throw new EmailExistException();
        User user = userService.createUser(userRequest.getOwnerEmail());
        return userService.saveUser(user);
    }

    @CrossOrigin
    @PutMapping(value = "/user/password")
    @ResponseStatus(ACCEPTED)
    @ApiOperation(value = "PUT", notes = "Set password")
    public void resetPassword(@RequestParam String uuid, @RequestBody Map<String, String> requesBody) {
        if (!userService.userExist(uuid)) throw new UserNotExistException();
        User user = userService.findUserByUuid(uuid);
        user.setPassWord(requesBody.get("password"));
        userService.saveUser(user);
    }

    @CrossOrigin
    @PostMapping(value = "/user/login")
    @ResponseStatus(FOUND)
    @ApiOperation(value = "POST", notes = "User login")
    public UserResponseCommand login(@RequestBody UserLoginRequestCommand userLoginRequestCommand) {
        if (!userService.verifyEmailAndPassword(userLoginRequestCommand)) throw new LoginFailedException();
        return new UserResponseCommand(userService.findUserByEmail(userLoginRequestCommand.getEmail()).getUuid());
    }
}
