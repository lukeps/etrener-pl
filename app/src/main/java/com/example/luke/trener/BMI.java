package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BMI extends AppCompatActivity {

    private EditText waga;
    private EditText wzrost;
    private Button przycisk;
    private TextView wynik1;
    private TextView wynik2;

    Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        toast = Toast.makeText(BMI.this, "Podaj odpowiednie wartości liczbowe !", Toast.LENGTH_SHORT);


        waga = (EditText) findViewById(R.id.waga1);
        wzrost = (EditText) findViewById(R.id.wzrost1);
        przycisk = (Button) findViewById(R.id.button2);
        wynik1 = (TextView) findViewById(R.id.wynik);
        wynik2 = (TextView)findViewById(R.id.wynik_bmi);

        waga.setText("");
        wzrost.setText("");

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ObliczBMI();


            }
        });
    }


    private void ObliczBMI() {

        try {


            Float wagaFlt = Float.parseFloat(waga.getText().toString());
            Float wzrostMetry = Float.parseFloat(wzrost.getText().toString()) / 100;


            if (wagaFlt <= 200 && wagaFlt>0 &&  wzrostMetry < 2.3 && wzrostMetry>0) {

                float bmi = wagaFlt / (wzrostMetry * wzrostMetry);


                DobranieBMI(bmi);

            }


            else {

                Toast.makeText(this,"Błędnie podany wzrost lub waga !",Toast.LENGTH_SHORT).show();
            }
        }


        catch ( Exception e) {

            toast.show();

        }


    }


    private void DobranieBMI(float bmi) {

        String wiadomosc = "";

        if (bmi < 16f) {

            wiadomosc = "Wygłodzenie";
        } else if (bmi < 16.99f) {

            wiadomosc = "Wychudzenie";

        } else if (bmi < 18.49f) {

            wiadomosc = "Niedowaga";


        } else if (bmi < 24.99f) {

            wiadomosc = "Wartość prawidłowa";


        } else if (bmi < 29.99f) {

            wiadomosc = "Nadwaga";


        } else if (bmi < 34.99f) {

            wiadomosc = "I stopień otyłości";


        } else if (bmi < 39.99f) {

            wiadomosc = "II stopień otyłości";

        } else if (bmi > 40f) {

            wiadomosc = "Otyłość skrajna";


        }

        wynik1.setText("Wskaźnik BMI wynosi :" + " " +  String.format("%.2f", bmi));
        wynik2.setText("i oznacza :" + " " + wiadomosc );

    }

}