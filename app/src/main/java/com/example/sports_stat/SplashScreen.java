package com.example.sports_stat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private final String PREF_NAME = "MyPrefFile";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash_screen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences settings = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
                String username = settings.getString("username", "No Username Found");

                if (username.equalsIgnoreCase("No Username Found")){
                    Intent intent = new Intent(SplashScreen.this , MainActivity.class);
                    startActivity(intent);
                    finish();

                }else{
                    Intent intent = new Intent(SplashScreen.this , menu.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);

    }
}