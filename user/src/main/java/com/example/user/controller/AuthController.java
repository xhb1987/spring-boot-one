package com.example.user.controller;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;


import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import com.example.user.service.CustomeUserDetailService;
import com.example.user.service.JwtServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
public class AuthController {
    @Autowired
    JwtServices jwtServices;

    @Autowired
    UserRepository users;

    @Autowired
    private CustomeUserDetailService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthBody data) {
        try {
            String username = data.getName();

            // authenticationManager.authenticate(new
            // UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtServices.createToken(username, this.users.findByName(username).getRole());
            Map<Object, Object> model = new HashMap();
            model.put("username", username);
            model.put("token", token);
            return ok(model);
        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid email password");
        }
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        userService.saveUser(user);
        return "ok";
    }
}