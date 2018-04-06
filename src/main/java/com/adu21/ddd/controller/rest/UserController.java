package com.adu21.ddd.controller.rest;

import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.contract.UserRegisterResponseVO;
import com.adu21.ddd.exception.EmailExistException;
import com.adu21.ddd.exception.ErrorInputException;
import com.adu21.ddd.service.PolicyService;
import com.adu21.ddd.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.CREATED;

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
    public UserRegisterResponseVO createUser(@RequestBody UserRegisterRequestVO userRequest) {
        if (!policyService.verifyPolicyNumber(userRequest) || userRequest.getEmail().equals("") ||
                userRequest.getPolicyNumber().equals("")) throw new ErrorInputException();
        if (userService.verifyEmail(userRequest.getEmail())) throw new EmailExistException();
        return userService.saveUser(userRequest.getEmail());
    }

//    @CrossOrigin
//    @PutMapping(value = "/user/{userId}/password")
//    @ResponseStatus(ACCEPTED)
//    @ApiOperation(value = "POST", notes = "Set password")
//    public void resetPassword(@PathVariable String userId, @RequestBody UserRegisterRequestVO userRequest) {
//        User user = userService.findUserById(Integer.parseInt(userId));
//        if (!user.getToken().equals(userRequest.getToken())) throw new TokenInvalidException();
//        user.setPassWord(userRequest.getPassword());
//        userService.saveUser(user);
//    }
//
//    @CrossOrigin
//    @PostMapping(value = "/user/login")
//    @ResponseStatus(FOUND)
//    @ApiOperation(value = "POST", notes = "User login")
//    public void login(@RequestBody UserRegisterRequestVO userRequest) {
//        if (!userService.verifyPassword(userRequest)) throw new WrongPasswordException();
//    }
}
