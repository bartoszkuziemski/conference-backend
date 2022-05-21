package com.example.conferencebackend.models;

import com.example.conferencebackend.models.dto.LectureDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Lecture")
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String subject;
    private String startTime;
    private String endTime;

    @ManyToMany(mappedBy = "registeredLectures")
    private List<User> users = new ArrayList<>();

//    public Lecture(String subject, String startTime, String endTime) {
//        this.subject = subject;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }

    public void addUser(User user) {
        users.add(user);
    }

    public static Lecture from(LectureDto lectureDto) {
        Lecture lecture = new Lecture();
        lecture.setSubject(lectureDto.getSubject());
        lecture.setStartTime(lectureDto.getStartTime());
        lecture.setEndTime(lectureDto.getEndTime());
        return lecture;
    }
}
