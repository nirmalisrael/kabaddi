package com.julius.kabaddi.controller;

import com.julius.kabaddi.dto.TeamRequest;
import com.julius.kabaddi.dto.TeamResponse;
import com.julius.kabaddi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/kms", produces = {MediaType.APPLICATION_JSON_VALUE})
@PreAuthorize("hasAuthority('SUPER_ADMIN')")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping(value = "/createTeam")
    public ResponseEntity<TeamResponse> createTeam(@RequestBody TeamRequest teamRequest) {
        try {
            return new ResponseEntity<>(teamService.createTeam(teamRequest), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value = "/modifyTeam")
    public ResponseEntity<TeamResponse> modifyTeam(@RequestParam String teamId, @RequestBody TeamRequest teamRequest) {
        try {
            return new ResponseEntity<>(teamService.modifyTeam(teamId, teamRequest), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/removeTeam")
    public ResponseEntity<Map<String, String>> removeTeam(@RequestParam String teamId) {
        try {
            return new ResponseEntity<>(teamService.removeTeam(teamId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getTeamById")
    public ResponseEntity<TeamResponse> getTeamById(@RequestParam String teamId) {
        try {
            return new ResponseEntity<>(teamService.getTeamById(teamId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getAllTeams")
    public ResponseEntity<List<TeamResponse>> getAllTeams() {
        try {
            return new ResponseEntity<>(teamService.getAllTeams(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
