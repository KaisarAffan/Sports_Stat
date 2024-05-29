package com.example.sports_stat;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.sports_stat.EnglandApi.FootballEngland;
import com.example.sports_stat.SpainAPI.FootballSpain;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class menu extends AppCompatActivity {

    FrameLayout frameLayout;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.menu);

        frameLayout = findViewById(R.id.frameLayout);
        bottomNavigationView = findViewById(R.id.menu);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ProfileLogOut()).addToBackStack(null).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                if(item.getItemId() == R.id.bangun_datar)
                {
                    fragment = new FootballEngland();
                }
                else if(item.getItemId() == R.id.bangun_ruang)
                {
                    fragment = new FootballSpain();
                }
                else if(item.getItemId() == R.id.profile)
                {
                    fragment = new ProfileLogOut();
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,fragment).setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).commit();

                return true;
            }
        });

    }
}