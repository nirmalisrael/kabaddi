package com.julius.kabaddi.entity;

import com.julius.kabaddi.dto.TeamRequest;

import javax.persistence.*;

@Entity
public class Team {

    @Id
    private String teamId;

    private String teamName;

    private String captainName;

    private long captainPhoneNumber;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    public Team(TeamRequest teamRequest) {
        if (teamRequest.getTeamName() != null)
            teamName = teamRequest.getTeamName();
        if (teamRequest.getCaptainName() != null)
            captainName = teamRequest.getCaptainName();
        if (teamRequest.getCaptainPhoneNumber() != 0)
            captainPhoneNumber = teamRequest.getCaptainPhoneNumber();
    }

    public Team() {
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        if (teamId != null)
            this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        if (teamName != null)
            this.teamName = teamName;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        if (captainName != null)
            this.captainName = captainName;
    }

    public long getCaptainPhoneNumber() {
        return captainPhoneNumber;
    }

    public void setCaptainPhoneNumber(long captainPhoneNumber) {
        if (captainPhoneNumber != 0)
            this.captainPhoneNumber = captainPhoneNumber;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}
