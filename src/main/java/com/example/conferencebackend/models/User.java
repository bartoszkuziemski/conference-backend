package com.example.conferencebackend.models;

import com.example.conferencebackend.models.dto.UserDto;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "[User]") // User is a keyword in SQL, we have to write name in []
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public static User from(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setLogin(userDto.getLogin());
        return user;
    }
}
