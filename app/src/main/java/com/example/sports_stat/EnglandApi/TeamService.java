package com.example.sports_stat.EnglandApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamService {
    @GET("search_all_teams.php?l=English%20Premier%20League")
    Call<TeamRespons> getTeams();
}
