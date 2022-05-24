package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class RoomNotFoundException extends RuntimeException {

    public RoomNotFoundException(final Long id) {
        super(MessageFormat.format("Could not find room with id: {0}", id));
    }

}
