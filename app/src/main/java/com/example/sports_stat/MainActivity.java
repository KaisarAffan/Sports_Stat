package com.example.sports_stat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final String PREF_NAME="MyPrefFile";
    Button btnLogin;
    EditText txtUsername,txtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();

        txtUsername =  findViewById(R.id.txtUsername);
        txtPassword =  findViewById(R.id.txtPassword);
        btnLogin =  findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(txtUsername.getText().toString().equals("admin") && txtPassword.getText().toString().equals("admin")){
                editor.putString("username", txtUsername.getText().toString());
                editor.apply();

                Toast.makeText(MainActivity.this, "Log in Succes ", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, menu.class);
                startActivity(intent);
                finish();}
                else {Toast.makeText(MainActivity.this, "Username atau password salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}