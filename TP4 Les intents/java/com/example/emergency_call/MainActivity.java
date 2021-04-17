package com.example.emergency_call;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button bouton_1;
    Button bouton_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bouton_1=(Button)findViewById(R.id.bouton1);
        bouton_2=(Button)findViewById(R.id.bouton2);

        bouton_1.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                startActivityForResult(intent,1);
            }
        });
        bouton_2.setOnClickListener(new OnClickListener(){
            public void onClick (View view){
                Intent intent=new Intent(MainActivity.this,MainActivity3.class);
                startActivityForResult(intent,2);
            }
        });
    }
    public void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (1):
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "Enfant1 OK", Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this, " Retour de l'enfant 1", Toast.LENGTH_SHORT).show();
                        return;
                }
            case (2):
                switch (resultCode) {
                    case RESULT_OK:
                        Toast.makeText(this, "Enfant2 OK", Toast.LENGTH_SHORT).show();
                        return;
                    case RESULT_CANCELED:
                        Toast.makeText(this, "Retour de l'enfant 2", Toast.LENGTH_SHORT).show();
                        return;
                }
        }

    }
}


