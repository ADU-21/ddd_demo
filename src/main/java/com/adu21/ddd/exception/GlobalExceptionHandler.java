package com.adu21.ddd.exception;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.FOUND;

@ControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorInputException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(ErrorInputException e) {
        return "You have input wrong information, please try it again.";
    }

    @ExceptionHandler(EmailExistException.class)
    @ResponseStatus(FOUND)
    @ResponseBody
    public String handleException(EmailExistException e) {
        return "Email already registered, please login.";
    }

    @ExceptionHandler(UserNotExistException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(UserNotExistException e) {
        return "Invalid uuid";
    }

    @ExceptionHandler(WrongPasswordException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(WrongPasswordException e) {
        return "Wrong password";
    }

}
