package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class UserNotFoundException extends RuntimeException {

//    public UserNotFoundException(final Long id) {
//        super(MessageFormat.format("Could not find user with id: {0}", id));
//    }

    public UserNotFoundException(final String username) {
        super(MessageFormat.format("Could not find user with username: {0}", username));
    }

}
