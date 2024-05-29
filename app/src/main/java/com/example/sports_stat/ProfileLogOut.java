package com.example.sports_stat;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ProfileLogOut extends Fragment {

    private final String PREF_NAME = "MyPrefFile";

    Button btnlogout;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_log_out, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SharedPreferences settings = getActivity().getSharedPreferences(PREF_NAME,MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        btnlogout = view.findViewById(R.id.logout);

        btnlogout.setOnClickListener(v->{
            editor.clear();
            editor.apply();
            Toast.makeText(getActivity(), "Log out Succes ", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);

        });
    }
}