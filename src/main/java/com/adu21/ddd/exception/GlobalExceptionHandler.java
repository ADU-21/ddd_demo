package com.adu21.ddd.exception;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.FORBIDDEN;

import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    @ResponseStatus(CONFLICT)
    @ResponseBody
    public String handleException(UserExistException e) {
        return "User already Exist";
    }

    @ExceptionHandler(TokenInvalidException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(TokenInvalidException e) {
        return "Invalid token";
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(WrongPasswordException e) {
        return "Wrong password";
    }

}
