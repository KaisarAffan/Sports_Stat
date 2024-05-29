package com.example.sports_stat.EnglandApi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sports_stat.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FootballEngland extends Fragment {

    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";

    private MyAdapter adapter;

    public FootballEngland() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_football_england, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = getView().findViewById(R.id.rv_england);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TeamService service = retrofit.create(TeamService.class);
        Call<TeamRespons> call = service.getTeams();

        call.enqueue(new Callback<TeamRespons>() {
            @Override
            public void onResponse(Call<TeamRespons> call, Response<TeamRespons> response) {
                if (response.isSuccessful()) {
                    TeamRespons teamResponse = response.body();
                    if (teamResponse != null) {
                        List<Team> teams = teamResponse.getTeams();
                        // display to recyclerView
                        adapter = new MyAdapter(teams,getActivity());
                        recyclerView.setAdapter(adapter);
                    }
                } else {
                    // Handle unsuccessful response
                }
            }

            @Override
            public void onFailure(Call<TeamRespons> call, Throwable t) {

            }
        });
    }
}