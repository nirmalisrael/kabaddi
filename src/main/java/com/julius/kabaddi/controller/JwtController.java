package com.julius.kabaddi.controller;

import com.julius.kabaddi.dto.JwtRequest;
import com.julius.kabaddi.dto.JwtResponse;
import com.julius.kabaddi.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/kms", produces = {MediaType.APPLICATION_JSON_VALUE})
public class JwtController {

    @Autowired
    JwtService jwtService;

    @PostMapping(value = "/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest jwtRequest) {
        try {
            return new ResponseEntity<>(jwtService.login(jwtRequest), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new JwtResponse(), HttpStatus.NOT_FOUND);
        }
    }
}
