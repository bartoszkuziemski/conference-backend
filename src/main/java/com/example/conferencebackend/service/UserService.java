package com.example.conferencebackend.service;

import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.User;
import com.example.conferencebackend.models.exception.UserNotFoundException;
import com.example.conferencebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final LectureService lectureService;

    @Autowired
    public UserService(UserRepository userRepository, LectureService lectureService) {
        this.userRepository = userRepository;
        this.lectureService = lectureService;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException(id));
    }

    public User deleteUser(Long id) {
        User user = getUser(id);
        userRepository.delete(user);
        return user;
    }

    @Transactional
    public User editUser(Long id, User user) {
        User userToEdit = getUser(id);
        userToEdit.setEmail(user.getEmail());
        return userToEdit;
    }

    @Transactional
    public User registerInLecture(Long userId, Long lectureId) {
        User user = getUser(userId);
        Lecture lecture = lectureService.getLecture(lectureId);
        // lecture.addUser(user);
        user.registerInLecture(lecture);
        return user;
    }

    @Transactional
    public User registerOutOfLecture(Long userId, Long lectureId) {
        User user = new User();
        Lecture lecture = lectureService.getLecture(lectureId);
        user.registerOutOfLecture(lecture);
        return user;
    }

}
