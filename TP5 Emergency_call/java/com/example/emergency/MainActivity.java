package com.example.emergency;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText numbre;
    ImageButton btcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numbre = findViewById(R.id.numbre);
        btcall = findViewById(R.id.bt_call);

        btcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = numbre.getText().toString();
                if (phone.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "please Enter Number !", Toast.LENGTH_SHORT).show();
                }
                else {
                    String s = "tel:" +phone;
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse(s));
                    startActivity(intent);
                }
            }
        });

    }

}