package com.example.luke.trener;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.content.Intent;
import android.widget.TextView;
import android.view.Menu;


import com.google.firebase.auth.FirebaseAuth;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {

    private ImageView atlas;
    private ImageView dieta;
    private ImageView dziennik;
    private ImageView bmi;
    private ImageView plantreningowy;
    private ImageView listatreningow;

    private TextView odczytanieimienia;
    private FirebaseAuth firebaseAuth3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth3 = FirebaseAuth.getInstance();

        odczytanieimienia = (TextView)findViewById(R.id.imie);

        String odczytaniezaktywnosci = getIntent().getExtras().getString("text");
        odczytanieimienia.setText(odczytaniezaktywnosci);









        atlas = (ImageView) findViewById(R.id.atlas);
        atlas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtworzAktywnoscAtlas();
            }
        });

        dieta = (ImageView) findViewById(R.id.dieta);
                dieta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        OtworzAktywnoscDieta();
                    }
                });

        dziennik = (ImageView) findViewById(R.id.dziennik);
        dziennik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtworzAktywnoscDziennik();
            }
        });



        bmi = (ImageView) findViewById(R.id.bmi);
        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtworzAktywnoscBMI();
            }
        });

        plantreningowy = (ImageView)findViewById(R.id.plantreningowy);
        plantreningowy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtworzAktywnoscPlanTreningowy();

            }
        });

        listatreningow = (ImageView)findViewById(R.id.listatreningow);
        listatreningow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OtworzAktywnoscListaTreningow();

            }
        });











    }


    public void OtworzAktywnoscAtlas(){

        Intent nowaAktywnosc = new Intent(this, AtlasCwiczen.class);
        startActivity(nowaAktywnosc);

    }

    public void OtworzAktywnoscDieta(){

        Intent nowaAktywnosc2 = new Intent(this, Dieta.class);
        startActivity(nowaAktywnosc2);

    }

    public void OtworzAktywnoscDziennik(){

        Intent nowaAktywnosc3 = new Intent(this, Dziennik.class);
        startActivity(nowaAktywnosc3);

    }

    public void OtworzAktywnoscBMI(){

        Intent nowaAktywnosc4 = new Intent(this, BMI.class);
        startActivity(nowaAktywnosc4);

    }

    public void OtworzAktywnoscPlanTreningowy() {
        Intent nowaAktywnosc5 = new Intent(this, PlanTreningowy.class);
            startActivity(nowaAktywnosc5);
    }

    public void OtworzAktywnoscListaTreningow() {
        Intent nowaAktywnosc6 = new Intent(this, ListaTreningow.class);
        startActivity(nowaAktywnosc6);
    }


    public void Wylogowanie(){



        firebaseAuth3.signOut();
        finish(); // metoda która uniemożliwia za pomocą przycisku cofnij w telefonie, powrót do aktywności z której się wylogowujemy
        Intent wroclogowanie = new Intent(this,Logowanie1.class);
        startActivity(wroclogowanie);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_glowne_actionbar, menu); // polaczenie widoku ( menu utworzonego w XML) z kodem javy
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.onas){ // jezeli kliknieto w opcje O nas, to utworz nowa aktywnosc i przejdz do niej

            Intent aktywnosc_o_nas = new Intent (this, oNas.class);
            startActivity(aktywnosc_o_nas);
        }

        else if(item.getItemId()==R.id.wyloguj){

            Wylogowanie();
        }

        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }






}
