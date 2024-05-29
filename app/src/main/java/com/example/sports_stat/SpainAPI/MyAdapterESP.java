package com.example.sports_stat.SpainAPI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sports_stat.R;

import java.util.List;

public class MyAdapterESP extends RecyclerView.Adapter<MyAdapterESP.teamViewHolder> {
        private List<Team> teamList;
        private Context context;

        public MyAdapterESP(List<com.example.sports_stat.SpainAPI.Team> teamList, Context context) {
            this.teamList = teamList;
            this.context = context;
        }


        @NonNull
        @Override
        public MyAdapterESP.teamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyAdapterESP.teamViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv,parent,false));
        }

    @Override
    public void onBindViewHolder(@NonNull teamViewHolder holder, int position) {
        holder.teamName.setText(teamList.get(position).getStrTeam());
        holder.teamStadium.setText(teamList.get(position).getStrStadium());
        Glide.with(context).load(teamList.get(position).getStrTeamBadge()).into(holder.teamBadge);
    }

        @Override
        public int getItemCount() {
            return teamList.size();
        }

public class teamViewHolder extends RecyclerView.ViewHolder {

    TextView teamName,teamStadium;
    ImageView teamBadge;
    public teamViewHolder(@NonNull View itemView) {
        super(itemView);
        teamName = itemView.findViewById(R.id.Tvtitle);
        teamStadium = itemView.findViewById(R.id.Tvdescription);
        teamBadge = itemView.findViewById(R.id.Ivimage);
    }
}
}
