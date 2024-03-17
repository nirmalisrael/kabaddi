package com.julius.kabaddi.controller;

import com.julius.kabaddi.entity.User;
import com.julius.kabaddi.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/kms", produces = {MediaType.APPLICATION_JSON_VALUE})
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/createUser")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        try {
            return new ResponseEntity<>(userService.createUser(user), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/removeUser")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<Map<String, String>> removeUser(String username) {
        Map<String, String> response = new HashMap<>();
        try {
            String deleteResponse = userService.removeUser(username);
            if (deleteResponse == null)
                response.put("message", username + " NOT FOUND");
            else
                response.put("message", deleteResponse);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getUserByUsername")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<User> getUserByUsername(@RequestParam String username) {
        try {
            User user = (User) userService.loadUserByUsername(username);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getAllUsers")
    @PreAuthorize("hasAuthority('SUPER_ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        try {
            return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
        } catch (Exception exception) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
