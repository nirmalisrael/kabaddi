package com.julius.kabaddi.service.impl;

import com.julius.kabaddi.dto.TournamentRequest;
import com.julius.kabaddi.dto.TournamentResponse;
import com.julius.kabaddi.entity.Tournament;
import com.julius.kabaddi.repository.TournamentRepository;
import com.julius.kabaddi.service.TournamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TournamentServiceImpl implements TournamentService {

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TournamentServiceImpl(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public TournamentResponse createTournament(TournamentRequest tournamentRequest) {
        Tournament tournament = new Tournament(tournamentRequest);
        tournament.setTournamentId(UUID.randomUUID().toString());
        tournament = tournamentRepository.save(tournament);
        return new TournamentResponse(tournament);
    }

    @Override
    public TournamentResponse modifyTournament(String tournamentId, TournamentRequest tournamentRequest) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(tournamentId);
        if (optionalTournament.isPresent()) {
            Tournament tournament = new Tournament(tournamentRequest);
            tournament.setTournamentId(tournamentId);
            tournament = tournamentRepository.save(tournament);
            return new TournamentResponse(tournament);
        }
        return null;
    }

    @Override
    public Map<String, String> removeTournament(String tournamentId) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(tournamentId);
        Map<String, String> response = new HashMap<>();
        if (optionalTournament.isPresent()) {
            tournamentRepository.deleteById(tournamentId);
            response.put("message", tournamentId);
            return response;
        }
        response.put("message", tournamentId + " NOT FOUND");
        return response;
    }

    @Override
    public TournamentResponse getTournamentById(String tournamentId) {
        Optional<Tournament> optionalTournament = tournamentRepository.findById(tournamentId);
        return optionalTournament.map(TournamentResponse::new).orElse(null);
    }

    @Override
    public List<TournamentResponse> getAllTournaments() {
        List<Tournament> tournaments = tournamentRepository.findAll();
        return tournaments.stream().map(TournamentResponse::new).toList();
    }
}
