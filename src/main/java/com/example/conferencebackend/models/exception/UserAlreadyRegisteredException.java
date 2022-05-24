package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class UserAlreadyRegisteredException extends RuntimeException {

    public UserAlreadyRegisteredException(final String time) {
        super(MessageFormat.format("You are already registered in lecture at the time", time));
    }

}
