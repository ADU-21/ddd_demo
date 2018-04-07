package com.adu21.ddd.controller.rest;

import com.adu21.ddd.contract.UserLoginRequestVO;
import com.adu21.ddd.contract.UserRegisterRequestVO;
import com.adu21.ddd.contract.UserResponseVO;
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
    public UserResponseVO createUser(@RequestBody UserRegisterRequestVO userRequest) {
        if (!policyService.verifyPolicyNumber(userRequest) || userRequest.getEmail().equals("") ||
                userRequest.getPolicyNumber().equals("")) throw new ErrorInputException();
        if (userService.verifyEmail(userRequest.getEmail())) throw new EmailExistException();
        User user = userService.createUser(userRequest.getEmail());
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
    public UserResponseVO login(@RequestBody UserLoginRequestVO userLoginRequestVO) {
        if (!userService.verifyEmailAndPassword(userLoginRequestVO)) throw new LoginFailedException();
        return new UserResponseVO(userService.findUserByEmail(userLoginRequestVO.getEmail()).getUuid());
    }
}
