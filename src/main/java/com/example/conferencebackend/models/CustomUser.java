package com.example.conferencebackend.models;

import com.example.conferencebackend.models.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "custom_user") // User is a keyword in SQL, we have to write name in []: "[User]"
public class CustomUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;
    private String email;

    @ManyToMany
    @JoinTable(
            name = "registered_lectures",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id")
    )
    private List<Lecture> registeredLectures = new ArrayList<>();


    public void registerInLecture(Lecture lecture) {
        registeredLectures.add(lecture);
    }

    public void registerOutOfLecture(Lecture lecture) {
        registeredLectures.remove(lecture);
    }

    public static CustomUser from(UserDto userDto) {
        CustomUser customUser = new CustomUser();
        customUser.setEmail(userDto.getEmail());
        customUser.setLogin(userDto.getLogin());
        return customUser;
    }
}
