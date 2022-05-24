package com.example.conferencebackend.models.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserAlreadyExist(UserAlreadyExistsException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserNotFound(UserNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserAlreadyRegisteredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserAlreadyRegistered(UserAlreadyRegisteredException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(RoomFullException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserAlreadyRegistered(RoomFullException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(UserNotRegisteredException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String handleUserAlreadyRegistered(UserNotRegisteredException exception) {
        return exception.getMessage();
    }

}
