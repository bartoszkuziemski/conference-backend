package com.example.conferencebackend.service;

import com.example.conferencebackend.models.CustomUser;
import com.example.conferencebackend.models.Lecture;
import com.example.conferencebackend.models.exception.UserAlreadyExistsException;
import com.example.conferencebackend.models.exception.UserNotFoundException;
import com.example.conferencebackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        CustomUser userToAdd = userRepository.findByUsername(customUser.getUsername());
        if (userToAdd == null) {
            return userRepository.save(customUser);
        } else {
            throw new UserAlreadyExistsException(customUser.getUsername());
        }
    }

    public List<CustomUser> getUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

//    public CustomUser getUser(Long id) {
//        return userRepository.findById(id).orElseThrow( () -> new UserNotFoundException(id));
//    }

    public CustomUser getUserByUsername(String username) {
        CustomUser customUser = userRepository.findByUsername(username);
        if (customUser == null) {
            throw new UserNotFoundException(username);
        }
        return customUser;
    }

    public void deleteUser(String username) {
        CustomUser customUser = getUserByUsername(username);
        userRepository.delete(customUser);
    }

    @Transactional
    public CustomUser editUser(String username, CustomUser customUser) {
        CustomUser customUserToEdit = getUserByUsername(username);
        customUserToEdit.setEmail(customUser.getEmail());
        return customUserToEdit;
    }

    @Transactional
    public CustomUser registerInLecture(String username, Long lectureId) {
        CustomUser customUser = getUserByUsername(username);
        Lecture lecture = lectureService.getLecture(lectureId);
        customUser.registerInLecture(lecture);
        return customUser;
    }

    @Transactional
    public CustomUser registerOutOfLecture(String username, Long lectureId) {
        CustomUser customUser = getUserByUsername(username);
        Lecture lecture = lectureService.getLecture(lectureId);
        customUser.registerOutOfLecture(lecture);
        return customUser;
    }

}
