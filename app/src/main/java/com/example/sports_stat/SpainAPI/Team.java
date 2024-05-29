package com.example.sports_stat.SpainAPI;

public class Team {
    private String idTeam;
    private String strTeam;
    private String strTeamBadge;
    private String strStadium;

    public Team(String idTeam, String strTeam, String strTeamBandage, String strStadium) {
        this.idTeam = idTeam;
        this.strTeam = strTeam;
        this.strTeamBadge = strTeamBandage;
        this.strStadium = strStadium;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
