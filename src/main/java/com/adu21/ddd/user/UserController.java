package com.adu21.ddd.user;

import com.adu21.ddd.exception.LoginFailedException;
import com.adu21.ddd.user.command.CreateUserCommand;
import com.adu21.ddd.user.command.SetPasswordCommand;
import com.adu21.ddd.user.command.UserLoginCommand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/user")
@Api(value = "User REST API", description = "User related API")
public class UserController {

    @Autowired
    private UserApplicationService userApplicationService;

    @CrossOrigin
    @PutMapping(value = "/register")
    @ResponseStatus(CREATED)
    @ApiOperation(value = "POST", notes = "Register")
    public String register(@RequestBody CreateUserCommand createUserCommand) {
        return userApplicationService.register(createUserCommand);
    }

    @CrossOrigin
    @PutMapping(value = "/password")
    @ResponseStatus(ACCEPTED)
    @ApiOperation(value = "PUT", notes = "Set password")
    public void setPassword(@RequestBody SetPasswordCommand setPasswordCommand) {
        userApplicationService.setPassword(setPasswordCommand);
    }

    @CrossOrigin
    @PostMapping(value = "/login")
    @ResponseStatus(FOUND)
    @ApiOperation(value = "POST", notes = "Login")
    public void login(@RequestBody UserLoginCommand userLoginCommand) {
        if (!userApplicationService.login(userLoginCommand)) throw new LoginFailedException();
    }
}
