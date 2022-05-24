package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class RoomFullException extends RuntimeException {

    public RoomFullException(final Long roomId) {
        super(MessageFormat.format("Room is already full, you cannot register to room: {0}", roomId));
    }

}
