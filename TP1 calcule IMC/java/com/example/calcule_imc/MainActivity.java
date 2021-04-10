package com.example.calcule_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final float[] imc = new float[1];
        Button btCalculer = (Button) findViewById(R.id.button);
        btCalculer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView editTaille = (TextView) findViewById(R.id.taille);
                TextView editPoids = (TextView) findViewById(R.id.poids);
                TextView IMC = (TextView) findViewById(R.id.rsltIMC);
                TextView remarque = (TextView) findViewById(R.id.Remarque);
                try {
                    IMC.setText("");
                    remarque.setText("");
                    int taille = Integer.parseInt(editTaille.getText().toString());
                    float poids = Float.parseFloat(editPoids.getText().toString());
                    imc[0] = (float) (poids / (taille/100.0 * taille/100.0));
                    if (imc[0] < 18.5) {
                        IMC.setText(imc[0] + "");
                        remarque.setText("Trop mence");

                    } else if (imc[0] < 25) {
                        IMC.setText(imc[0] + "");
                        remarque.setText("à l'état idiale");
                    } else if (imc[0] < 30) {
                        IMC.setText(imc[0] + "surpoids");
                        remarque.setText("");
                    } else {
                        IMC.setText(imc[0] + "");
                        remarque.setText("Malhereusement, obèse");
                    }

                }catch (Exception  e){

                }

            }

        });


    }

}