package com.julius.kabaddi.service;

import com.julius.kabaddi.dto.TournamentRequest;
import com.julius.kabaddi.dto.TournamentResponse;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.List;

@Service
public interface TournamentService {

    TournamentResponse createTournament(TournamentRequest tournamentRequest);

    TournamentResponse modifyTournament(String tournamentId, TournamentRequest tournamentRequest);

    Map<String, String> removeTournament(String tournamentId);

    TournamentResponse getTournamentById(String tournamentId);

    List<TournamentResponse> getAllTournaments();
}
