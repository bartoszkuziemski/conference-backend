package com.example.conferencebackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String startTime;
    private String endTime;
    private Integer capacity;

    @OneToMany
    @JoinColumn(name = "room_id")
    private List<Lecture> lectures = new ArrayList<>();

    public Room() {
    }

    public Room(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = 5;
    }

    public void addLecture(Lecture lecture) {
        lectures.add(lecture);
    }

    public void decreaseCapacity() {
        this.capacity--;
    }

    public void increaseCapacity() {
        this.capacity++;
    }
}