package com.julius.kabaddi.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.julius.kabaddi.entity.Team;
import com.julius.kabaddi.entity.Tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class TournamentResponse {

    private String tournamentId;

    private String tournamentName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tournamentDate;

    private Gender gender;

    private int weightLimit;

    private long phoneNumber;

    private String place;

    private List<TeamResponse> teamResponseList = Collections.emptyList();

    public TournamentResponse() {
    }

    public TournamentResponse(Tournament tournament) {
        if (tournament.getTournamentId() != null)
            tournamentId = tournament.getTournamentId();
        if (tournament.getTournamentName() != null)
            tournamentName = tournament.getTournamentName();
        if (tournament.getTournamentDate() != null)
            tournamentDate = tournament.getTournamentDate();
        if (tournament.getGender() != null)
            gender = tournament.getGender();
        if (tournament.getWeightLimit() != 0)
            weightLimit = tournament.getWeightLimit();
        if (tournament.getPhoneNumber() != 0)
            phoneNumber = tournament.getPhoneNumber();
        if (tournament.getPlace() != null)
            place = tournament.getPlace();
        if (!tournament.getTeamList().isEmpty()) {
            List<TeamResponse> teamResponses = new ArrayList<>();
            for(Team team: tournament.getTeamList()) {
                teamResponses.add(new TeamResponse(team));
            }
            teamResponseList = teamResponses;
        }
    }

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public Date getTournamentDate() {
        return tournamentDate;
    }

    public void setTournamentDate(Date tournamentDate) {
        this.tournamentDate = tournamentDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(int weightLimit) {
        this.weightLimit = weightLimit;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public List<TeamResponse> getTeamResponseList() {
        return teamResponseList;
    }

    public void setTeamResponseList(List<TeamResponse> teamResponseList) {
        this.teamResponseList = teamResponseList;
    }
}
