package com.example.fragments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    Button btn2 ;
    TextView txtInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn1 = (Button) findViewById(R.id.button1);
        Button btn2 = (Button) findViewById(R.id.button2);
        TextView txtInfo = (TextView) findViewById(R.id.textView);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SettingsActivity.class));
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                StringBuilder info = new StringBuilder();
                info.append("Nom et prénom: " + sharedPreferences.getString("key_name",""));
                info.append("\nEmail: " + sharedPreferences.getString("key_mail",""));
                info.append("\nAge: " + sharedPreferences.getString("key_age",""));
                info.append("\nRégion: " + sharedPreferences.getString("key_region",""));
                info.append("\nMusique: " + sharedPreferences.getString("key_music",""));
                info.append("\nActivités: " + sharedPreferences.getString("key_activity",""));

                txtInfo.setText(info);
            }
        });


    }

}