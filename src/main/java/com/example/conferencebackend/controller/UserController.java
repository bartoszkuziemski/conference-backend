package com.example.conferencebackend.controller;

import com.example.conferencebackend.models.CustomUser;
import com.example.conferencebackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "{username}")
    public ResponseEntity<CustomUser> getUserByUsername(@PathVariable final String username) {
        CustomUser customUser = userService.getUserByUsername(username);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CustomUser>> getUsers() {
        List<CustomUser> customUsers = userService.getUsers();
        return new ResponseEntity<>(customUsers, HttpStatus.OK);
    }

    @DeleteMapping(value = "{username}")
    public ResponseEntity<String> deleteUser(@PathVariable final String username) {
        userService.deleteUser(username);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @PutMapping(value = "{username}")
    public ResponseEntity<CustomUser> editUser(@PathVariable final String username, @RequestBody final CustomUser customUser) {
        return new ResponseEntity<>(userService.editUser(username, customUser), HttpStatus.OK);
    }

    @PutMapping(value = "{username}/lectures/{lectureId}/register")
    public ResponseEntity<CustomUser> registerInLecture(@PathVariable final String username, @PathVariable final Long lectureId) {
        CustomUser customUser = userService.registerInLecture(username, lectureId);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }

    @DeleteMapping(value = "{username}/lectures/{lectureId}/register")
    public ResponseEntity<CustomUser> registerOutOfLecture(@PathVariable final String username, @PathVariable final Long lectureId) {
        CustomUser customUser = userService.registerOutOfLecture(username, lectureId);
        return new ResponseEntity<>(customUser, HttpStatus.OK);
    }



}
