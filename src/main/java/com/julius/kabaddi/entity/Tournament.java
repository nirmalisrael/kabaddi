package com.julius.kabaddi.entity;

import java.util.Collections;
import java.util.List;

import com.julius.kabaddi.dto.Gender;
import com.julius.kabaddi.dto.TournamentRequest;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Date;

@Entity
public class Tournament {

    @Id
    private String tournamentId;

    private String tournamentName;

    private Date tournamentDate;

    private Gender gender;

    private int weightLimit;

    private long phoneNumber;

    private String place;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private List<Team> teamList = Collections.emptyList();

    public Tournament() {
    }

    public Tournament(TournamentRequest tournamentRequest) {
        if (tournamentRequest.getTournamentName() != null)
            tournamentName = tournamentRequest.getTournamentName();
        if (tournamentRequest.getTournamentDate() != null)
            tournamentDate = tournamentRequest.getTournamentDate();
        if (tournamentRequest.getGender() != null)
            gender = tournamentRequest.getGender();
        if (tournamentRequest.getWeightLimit() != 0)
            weightLimit = tournamentRequest.getWeightLimit();
        if (tournamentRequest.getPhoneNumber() != 0)
            phoneNumber = tournamentRequest.getPhoneNumber();
        if (tournamentRequest.getPlace() != null)
            place = tournamentRequest.getPlace();
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

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }
}
