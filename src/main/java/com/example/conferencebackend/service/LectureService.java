package com.example.conferencebackend.service;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.exception.LectureNotFoundException;
import com.example.conferencebackend.repository.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class LectureService {

    private final LectureRepository lectureRepository;

    @Autowired
    public LectureService(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    public Lecture addLecture(Lecture lecture) {
        return lectureRepository.save(lecture);
    }

    public List<Lecture> getLectures() {
        return StreamSupport.stream(lectureRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Lecture getLecture(Long id) {
        return lectureRepository.findById(id).orElseThrow( () -> new LectureNotFoundException(id));
    }

    //// TODO: 21.05.2022 delete lecture, edit lecture etc.

}
