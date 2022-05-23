package com.example.conferencebackend.service;

import com.example.conferencebackend.models.CustomUser;
import com.example.conferencebackend.models.Lecture;
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

    public CustomUser addUser(CustomUser customUser) {
        return userRepository.save(customUser);
    }

    public List<CustomUser> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public CustomUser getUser(Long id) {
        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException(id));
    }

    public CustomUser getUserByLogin(String login) {
        CustomUser customUser = userRepository.findByLogin(login);
        return customUser;
    }

    public CustomUser deleteUser(Long id) {
        CustomUser customUser = getUser(id);
        userRepository.delete(customUser);
        return customUser;
    }

    @Transactional
    public CustomUser editUser(Long id, CustomUser customUser) {
        CustomUser customUserToEdit = getUser(id);
        customUserToEdit.setEmail(customUser.getEmail());
        return customUserToEdit;
    }

    @Transactional
    public CustomUser registerInLecture(Long userId, Long lectureId) {
        CustomUser customUser = getUser(userId);
        Lecture lecture = lectureService.getLecture(lectureId);
        customUser.registerInLecture(lecture);
        return customUser;
    }

    @Transactional
    public CustomUser registerOutOfLecture(Long userId, Long lectureId) {
        CustomUser customUser = new CustomUser();
        Lecture lecture = lectureService.getLecture(lectureId);
        customUser.registerOutOfLecture(lecture);
        return customUser;
    }

}
