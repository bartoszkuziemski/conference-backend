package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(final String username) {
        super(MessageFormat.format("Username {0} already exist", username));
    }

}
