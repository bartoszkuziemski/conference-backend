package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class UserNotRegisteredException extends RuntimeException {

    public UserNotRegisteredException(final Long lectureId) {
        super(MessageFormat.format("You are not registered in lecture: {0}", lectureId));
    }

}
