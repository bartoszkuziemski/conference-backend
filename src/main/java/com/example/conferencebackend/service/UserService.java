package com.example.conferencebackend.service;

import com.example.conferencebackend.models.User;
import com.example.conferencebackend.models.UserNotFoundException;
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

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
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

}
