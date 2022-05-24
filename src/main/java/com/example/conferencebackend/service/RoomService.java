package com.example.conferencebackend.service;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.Room;
import com.example.conferencebackend.models.exception.RoomNotFoundException;
import com.example.conferencebackend.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RoomService {

    private final RoomRepository roomRepository;
    private final LectureService lectureService;

    @Autowired
    public RoomService(RoomRepository roomRepository, LectureService lectureService) {
        this.roomRepository = roomRepository;
        this.lectureService = lectureService;
    }

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getRooms() {
        return StreamSupport.stream(roomRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Room getRoom(Long id) {
        return roomRepository.findById(id).orElseThrow( () -> new RoomNotFoundException(id));
    }

    //// TODO: 24.05.2022 delete, edit etc.

    public Room addLectureToRoom(Long lectureId, Long roomId) {
        Room room = getRoom(roomId);
        Lecture lecture = lectureService.getLecture(lectureId);
        room.addLecture(lecture);
        lecture.setRoom(room);
        return room;
    }

}
