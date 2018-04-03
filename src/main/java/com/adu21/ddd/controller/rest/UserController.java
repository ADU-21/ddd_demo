package com.adu21.ddd.controller.rest;

import com.adu21.ddd.contract.UserRequestVO;
import com.adu21.ddd.contract.UserResponseVO;
import com.adu21.ddd.model.User;
import com.adu21.ddd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/api/${api.version}")
public class UserController {

    @Autowired
    private UserService userService;

    // Create user
    @CrossOrigin
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<UserResponseVO> createUser(@RequestBody UserRequestVO userRequest) {
        User user = userService.createUser(userRequest);
        if(userService.userExist(user)) {
            return ResponseEntity.status(CONFLICT).body(new UserResponseVO());
        }else {
            UserResponseVO userResponse = userService.saveUser(user);
            return ResponseEntity.status(CREATED).body(userResponse);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/user/{userId}/password", method = RequestMethod.PUT)
    public ResponseEntity<Void> resetPassword(@PathVariable String userId, @RequestBody UserRequestVO userRequest){
        User user = userService.findUserById(Integer.parseInt(userId));
        if(user.getToken().equals(userRequest.getToken())) {
           user.setPassWord(userRequest.getPassword());
           userService.saveUser(user);
           return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }else{
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public ResponseEntity<Void> login(@RequestBody UserRequestVO userRequest) {
        return (userService.verifyPassword(userRequest) ? new ResponseEntity<>(HttpStatus.FOUND) :
                new ResponseEntity<>(HttpStatus.FORBIDDEN));
    }
}
