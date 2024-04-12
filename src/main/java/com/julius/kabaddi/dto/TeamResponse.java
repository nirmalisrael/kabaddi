package com.julius.kabaddi.dto;

import com.julius.kabaddi.entity.Team;

public class TeamResponse {

    private String teamId;

    private String teamName;

    private String captainName;

    private long captainPhoneNumber;

    private String tournamentId;

    public TeamResponse() {
    }

    public TeamResponse(Team team) {
        if (team.getTeamId() != null)
            teamId = team.getTeamId();
        if (team.getTeamName() != null)
            teamName = team.getTeamName();
        if (team.getCaptainName() != null)
            captainName = team.getCaptainName();
        if (team.getCaptainPhoneNumber() != 0)
            captainPhoneNumber = team.getCaptainPhoneNumber();
        if (team.getTournament().getTournamentId() != null)
            tournamentId = team.getTournament().getTournamentId();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public long getCaptainPhoneNumber() {
        return captainPhoneNumber;
    }

    public void setCaptainPhoneNumber(long captainPhoneNumber) {
        this.captainPhoneNumber = captainPhoneNumber;
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }
}
