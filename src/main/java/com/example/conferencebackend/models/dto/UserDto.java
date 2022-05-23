package com.example.conferencebackend.models.dto;

import com.example.conferencebackend.models.CustomUser;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String login;
    private String email;

    private List<LectureDto> registeredLecturesDto = new ArrayList<>();

    public static UserDto from(CustomUser customUser) {
        UserDto userDto = new UserDto();
        userDto.setId(customUser.getId());
        userDto.setLogin(customUser.getLogin());
        userDto.setEmail(customUser.getEmail());
        userDto.setRegisteredLecturesDto(customUser.getRegisteredLectures().stream().map(LectureDto::from).collect(Collectors.toList()));
        return userDto;
    }

}
