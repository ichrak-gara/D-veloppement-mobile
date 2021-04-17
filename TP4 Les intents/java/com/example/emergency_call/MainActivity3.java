package com.example.emergency_call;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity3 extends AppCompatActivity {

    Button B_OK;
    Button B_AN;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        B_AN=(Button)findViewById(R.id.boutonANNULER2);
        B_AN.setOnClickListener (new OnClickListener () {
            public void onClick (View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
    }
}
