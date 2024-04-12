package com.julius.kabaddi.service.impl;


import com.julius.kabaddi.dto.JwtRequest;
import com.julius.kabaddi.dto.JwtResponse;
import com.julius.kabaddi.entity.User;
import com.julius.kabaddi.service.JwtService;
import com.julius.kabaddi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtUtil jwtUtil;

    @Override
    public JwtResponse login(JwtRequest jwtRequest) {
        Authentication authentication = authManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtRequest.getUsername(),
                        jwtRequest.getPassword()));

        User user = (User) authentication.getPrincipal();
        String jwt = "Bearer " + jwtUtil.generateAccessToken(user);
        return new JwtResponse(user.getUsername(), user.getRoles(), jwt);
    }
}