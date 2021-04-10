package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Convert_Temperature extends AppCompatActivity {

    private EditText entrer;
    private RadioButton rb1;
    private RadioButton rb2;
    private Button btn;
    private TextView rlt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert__temperature);

        entrer = findViewById(R.id.val);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        btn = findViewById(R.id.btn);
        rlt = findViewById(R.id.rlt);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (rb1.isChecked()){
                    String z = entrer.getText().toString();
                    double i = Double.parseDouble(z);
                    double val = ((i-32)*5/9);

                    rlt.setText(Double.toString((double) val ));
                }
                else if (rb2.isChecked()) {
                    String z = entrer.getText().toString();
                    double i = Double.parseDouble(z);
                    double val = ((i * 9/5)+32);

                    rlt.setText(Double.toString((double) val));
                }
            }
        });
    }
}