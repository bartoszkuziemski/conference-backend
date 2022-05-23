package com.example.conferencebackend.controller;

import com.example.conferencebackend.models.CustomUser;
import com.example.conferencebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CustomUser> addUser(@RequestBody final CustomUser customUser) {
        return new ResponseEntity<>(userService.addUser(customUser), HttpStatus.OK);
    }

//    @GetMapping(value = "{id}")
//    public ResponseEntity<CustomUser> getUser(@PathVariable final Long id) {
//        CustomUser customUser = userService.getUser(id);
//        return new ResponseEntity<>(customUser, HttpStatus.OK);
//    }

    @GetMapping(value = "{login}")
    public ResponseEntity<CustomUser> getUserByLogin(@PathVariable final String login) {
        CustomUser customUser = userService.getUserByLogin(login);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomUser>> getUsers() {
        List<CustomUser> customUsers = userService.getUsers();
        return new ResponseEntity<>(customUsers, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(value = "{id}")
    public ResponseEntity<CustomUser> deleteUser(@PathVariable final Long id) {
        CustomUser customUser = userService.deleteUser(id);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<CustomUser> editUser(@PathVariable final Long id, @RequestBody final CustomUser customUser) {
        return new ResponseEntity<>(userService.editUser(id, customUser), HttpStatus.OK);
    }

    @PutMapping(value = "{userId}/lectures/{lectureId}/add")
    public ResponseEntity<CustomUser> registerInLecture(@PathVariable final Long userId, @PathVariable final Long lectureId) {
        CustomUser customUser = userService.registerInLecture(userId, lectureId);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }



}
