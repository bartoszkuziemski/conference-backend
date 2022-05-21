package com.example.conferencebackend.controller;

import com.example.conferencebackend.models.User;
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
    public ResponseEntity<User> addUser(@RequestBody final User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<User> getUser(@PathVariable final Long id) {
        User user = userService.getUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Transactional
    @DeleteMapping(value = "{id}")
    public ResponseEntity<User> deleteUser(@PathVariable final Long id) {
        User user = userService.deleteUser(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping(value = "{id}")
    public ResponseEntity<User> editUser(@PathVariable final Long id, @RequestBody final User user) {
        return new ResponseEntity<>(userService.editUser(id, user), HttpStatus.OK);
    }

    @PutMapping(value = "{userId}/lectures/{lectureId}/add")
    public ResponseEntity<User> registerInLecture(@PathVariable final Long userId, @PathVariable final Long lectureId) {
        User user = userService.registerInLecture(userId, lectureId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



}
