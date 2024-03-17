package com.julius.kabaddi.service;

import com.julius.kabaddi.dto.JwtRequest;
import com.julius.kabaddi.dto.JwtResponse;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

    JwtResponse login(JwtRequest jwtRequest);
}
