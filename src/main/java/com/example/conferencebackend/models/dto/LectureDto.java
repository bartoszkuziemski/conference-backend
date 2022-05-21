package com.example.conferencebackend.models.dto;

import com.example.conferencebackend.models.Lecture;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class LectureDto {

    private Long id;
    private String subject;
    private String startTime;
    private String endTime;

    private List<UserDto> usersDto = new ArrayList<>();

    public static LectureDto from(Lecture lecture) {
        LectureDto lectureDto = new LectureDto();
        lectureDto.setId(lecture.getId());
        lectureDto.setSubject(lecture.getSubject());
        lectureDto.setStartTime(lecture.getStartTime());
        lectureDto.setEndTime(lecture.getEndTime());
        lectureDto.setUsersDto(lecture.getUsers().stream().map(UserDto::from).collect(Collectors.toList()));
        return lectureDto;
    }

}
