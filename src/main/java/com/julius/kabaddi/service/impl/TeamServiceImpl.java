package com.julius.kabaddi.service.impl;

import com.julius.kabaddi.dto.TeamRequest;
import com.julius.kabaddi.dto.TeamResponse;
import com.julius.kabaddi.entity.Team;
import com.julius.kabaddi.entity.Tournament;
import com.julius.kabaddi.repository.TeamRepository;
import com.julius.kabaddi.repository.TournamentRepository;
import com.julius.kabaddi.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;

    private final TournamentRepository tournamentRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository, TournamentRepository tournamentRepository) {
        this.teamRepository = teamRepository;
        this.tournamentRepository = tournamentRepository;
    }

    @Override
    public TeamResponse createTeam(TeamRequest teamRequest) {
        Tournament tournament = tournamentRepository.findById(teamRequest.getTournamentId()).orElseThrow(()
                -> new RuntimeException(teamRequest.getTournamentId() + " TOURNAMENT NOT FOUND!!!"));
        Team team = new Team(teamRequest);
        team.setTeamId(UUID.randomUUID().toString());
        team.setTournament(tournament);
        return new TeamResponse(teamRepository.save(team));
    }

    @Override
    public TeamResponse modifyTeam(String teamId, TeamRequest teamRequest) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isPresent()) {
            Team team = optionalTeam.get();
            team.setTeamName(teamRequest.getTeamName());
            team.setCaptainName(teamRequest.getCaptainName());
            team.setCaptainPhoneNumber(teamRequest.getCaptainPhoneNumber());
            Tournament tournament;
            String tournamentId = teamRequest.getTournamentId();
            if (tournamentId != null && !Objects.equals(tournamentId, "")) {
                tournament = tournamentRepository.findById(tournamentId).orElseThrow(()
                -> new RuntimeException(tournamentId + " TOURNAMENT NOT FOUND!!!"));
                team.setTournament(tournament);
            }
            return new TeamResponse(teamRepository.save(team));
        }
        return null;
    }

    @Override
    public Map<String, String> removeTeam(String teamId) {
        Map<String, String> response = new HashMap<>();
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isPresent()) {
            teamRepository.deleteById(teamId);
            response.put("message", teamId);
            return response;
        }
        response.put("message", teamId + " TEAM NOT FOUND");
        return response;
    }

    @Override
    public TeamResponse getTeamById(String teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        return new TeamResponse(Objects.requireNonNull(optionalTeam.orElse(null)));
    }

    @Override
    public List<TeamResponse> getAllTeams() {
        return teamRepository.findAll().stream().map(TeamResponse::new).toList();
    }
}
