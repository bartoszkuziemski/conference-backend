package com.example.conferencebackend.controller;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.dto.LectureDto;
import com.example.conferencebackend.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/lectures")
public class LectureController {

    private final LectureService lectureService;

    @Autowired
    public LectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping
    public ResponseEntity<List<LectureDto>> getLectures() {
        List<Lecture> lectures = lectureService.getLectures();
        List<LectureDto> lecturesDto = lectures.stream().map(LectureDto::from).collect(Collectors.toList());
        return new ResponseEntity<>(lecturesDto, HttpStatus.OK);
    }

}
