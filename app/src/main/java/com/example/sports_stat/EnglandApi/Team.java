package com.example.sports_stat.EnglandApi;

public class Team {
    private String idTeam;
    private String strTeamBadge;
    private String strTeam;

    private String strStadium;

    public Team(String idTeam, String strTeamBandage, String strTeam, String strStadium) {
        this.idTeam = idTeam;
        this.strTeamBadge = strTeamBandage;
        this.strTeam = strTeam;
        this.strStadium = strStadium;
    }

    public String getIdTeam() {
        return idTeam;
    }

    public String getStrTeamBadge() {
        return strTeamBadge;
    }

    public String getStrTeam() {
        return strTeam;
    }

    public String getStrStadium() {
        return strStadium;
    }
}
