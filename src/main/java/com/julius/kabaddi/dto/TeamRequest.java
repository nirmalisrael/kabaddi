package com.julius.kabaddi.dto;

public class TeamRequest {

    private String teamName;

    private String captainName;

    private long captainPhoneNumber;

    private String tournamentId;

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
