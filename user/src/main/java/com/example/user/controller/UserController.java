package com.example.user.controller;

import java.util.List;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        List<User> users = repository.findAll();
        return users;
    }

    @RequestMapping(value="/{username}", method=RequestMethod.GET)
    public User getUserByName(@PathVariable("username") String username) {
        User user = repository.findByName(username);
        return user;
    }
    
}