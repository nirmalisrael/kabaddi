package com.julius.kabaddi.controller;

import com.julius.kabaddi.dto.TournamentRequest;
import com.julius.kabaddi.dto.TournamentResponse;
import com.julius.kabaddi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;

@RestController
@RequestMapping(value = "/kms", produces = {MediaType.APPLICATION_JSON_VALUE})
@PreAuthorize("hasAuthority('SUPER_ADMIN')")
public class TournamentController {

    private final TournamentService tournamentService;

    @Autowired
    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @PostMapping(value = "/createTournament")
    public ResponseEntity<TournamentResponse> createTournament(@RequestBody TournamentRequest tournamentRequest) {
        try {
            return new ResponseEntity<>(tournamentService.createTournament(tournamentRequest), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PutMapping(value = "/modifyTournament")
    public ResponseEntity<TournamentResponse> modifyTournament(@RequestParam String tournamentId, @RequestBody TournamentRequest tournamentRequest) {
        try {
            return new ResponseEntity<>(tournamentService.modifyTournament(tournamentId, tournamentRequest), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping(value = "/removeTournament")
    public ResponseEntity<Map<String, String>> removeTournament(@RequestParam String tournamentId) {
        try {
            return new ResponseEntity<>(tournamentService.removeTournament(tournamentId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getTournamentById")
    public ResponseEntity<TournamentResponse> getTournamentById(@RequestParam String tournamentId) {
        try {
            return new ResponseEntity<>(tournamentService.getTournamentById(tournamentId), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping(value = "/getAllTournaments")
    public ResponseEntity<List<TournamentResponse>> getAllTournaments() {
        try {
            return new ResponseEntity<>(tournamentService.getAllTournaments(), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
    }
}
