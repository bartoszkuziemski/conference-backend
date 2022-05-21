package com.example.conferencebackend.models.dto;

import com.example.conferencebackend.models.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class UserDto {

    private Long id;
    private String login;
    private String email;
    private List<LectureDto> registeredLecturesDto = new ArrayList<>();

    public static UserDto from(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setEmail(user.getEmail());
        userDto.setRegisteredLecturesDto(user.getRegisteredLectures().stream().map(LectureDto::from).collect(Collectors.toList()));
        return userDto;
    }

}
