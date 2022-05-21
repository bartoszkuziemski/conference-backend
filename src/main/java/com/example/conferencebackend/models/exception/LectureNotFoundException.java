package com.example.conferencebackend.models.exception;

import java.text.MessageFormat;

public class LectureNotFoundException extends RuntimeException {

    public LectureNotFoundException(final Long id) {
        super(MessageFormat.format("Could not find lecture with id: {0}", id));
    }

}
