package com.example.application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private EditText nb ;
    private RadioButton B1;
    private RadioButton B2;
    private Button convert;
    private TextView rslt;
    private RadioGroup RG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        nb = findViewById(R.id.nombre);
        B1 = findViewById(R.id.radioButton1);
        B2 = findViewById(R.id.radioButton2);
        convert = findViewById(R.id.button2);
        rslt = findViewById(R.id.valeur);


        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (B1.isChecked()){
                    String s = nb.getText().toString();
                    double i = Double.parseDouble(s);
                    double val = i*0.31;

                    rslt.setText(Double.toString((double) val ));
                }
                else if (B2.isChecked()) {
                    String s = nb.getText().toString();
                    double i = Double.parseDouble(s);
                    double val = i * 3.26;

                    rslt.setText(Double.toString((double) val));
                }
            }
        });

        RadioGroup RG = findViewById(R.id.radioGroup2);
        // TextView test = findViewById(R.id.textView3);
        registerForContextMenu(RG);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu, menu);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.first){
            Intent intent = new Intent(SecondActivity.this,Euro2Dinar.class);
            startActivity(intent);
            return true ;
        }
        else if (id == R.id.second){
            Intent intent = new Intent(SecondActivity.this,Dinar2Euro.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.third){
            Intent intent = new Intent(SecondActivity.this,Convert_Temperature.class);
            startActivity(intent);
            return true;
        }
        else if (id == R.id.quitter){
            Intent intent = new Intent(SecondActivity.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onContextItemSelected(item);
    }
}








