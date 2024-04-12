package com.julius.kabaddi.service;

import com.julius.kabaddi.dto.TeamRequest;
import com.julius.kabaddi.dto.TeamResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TeamService {

    TeamResponse createTeam(TeamRequest teamRequest);

    TeamResponse modifyTeam(String teamId, TeamRequest teamRequest);

    Map<String, String> removeTeam(String teamId);

    TeamResponse getTeamById(String teamId);

    List<TeamResponse> getAllTeams();
}
