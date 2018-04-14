package com.adu21.ddd.exception;

import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

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
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public String handleException(UserNotExistException e) {
        return "Invalid uuid";
    }

    @ExceptionHandler(LoginFailedException.class)
    @ResponseStatus(FORBIDDEN)
    @ResponseBody
    public String handleException(LoginFailedException e) {
        return "Login failed";
    }

    @ExceptionHandler(PolicyNotExistException.class)
    @ResponseStatus(NOT_FOUND)
    @ResponseBody
    public String handleException(PolicyNotExistException e) {
        return "Invalid policyNumber";
    }

    @ExceptionHandler(InvalidQuotationException.class)
    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    public String handleException(InvalidQuotationException e) {
        return "Please input information again";
    }

}
