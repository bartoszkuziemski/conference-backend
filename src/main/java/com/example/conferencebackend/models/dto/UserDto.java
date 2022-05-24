package com.example.conferencebackend.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class UserDto {

    private Long id;
    private String login;
    private String email;
    private String password;

    private List<LectureDto> registeredLecturesDto = new ArrayList<>();

//    public static UserDto from(CustomUser customUser) {
//        UserDto userDto = new UserDto();
//        userDto.setId(customUser.getId());
//        userDto.setLogin(customUser.getLogin());
//        userDto.setEmail(customUser.getEmail());
//        userDto.setRegisteredLecturesDto(customUser.getRegisteredLectures().stream().map(LectureDto::from).collect(Collectors.toList()));
//        return userDto;
//    }

}
