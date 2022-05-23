package com.example.conferencebackend.models;

import com.example.conferencebackend.models.dto.LectureDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    private String startTime;
    private String endTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "registeredLectures")
    private List<User> users = new ArrayList<>();

//    public void addUser(User user) {
//        users.add(user);
//    }

    public static Lecture from(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        lecture.setSubject(lectureDto.getSubject());
        lecture.setStartTime(lectureDto.getStartTime());
        lecture.setEndTime(lectureDto.getEndTime());
        return lecture;
    }
}
