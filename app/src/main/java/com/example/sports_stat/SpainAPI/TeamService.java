package com.example.sports_stat.SpainAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TeamService {
    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<TeamRespons> getTeams();
}
