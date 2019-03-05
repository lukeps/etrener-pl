package com.example.luke.trener;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;

import android.net.Uri;
import android.os.Environment;
import android.os.Message;
import android.os.StrictMode;
import android.preference.PreferenceManager;

import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class GotowyPlanTreningowy extends AppCompatActivity {


    private TextView odczytanieopcji;
    private TextView odczytanieopcji2;
    private TextView odczytanieopcji3;
    private TextView odczytanieopcji4;
    private TextView odczytanieopcji5;
    private TextView odczytanieopcji6;
    private TextView odczytanieopcji7;
    private TextView odczytanieopcji8;
    private TextView odczytanieopcji9;
    private TextView odczytanieopcji10;
    private TextView odczytanieopcji11;
    private TextView odczytanieopcji12;
    private TextView odczytanieopcji13;
    private TextView odczytanieopcji14;
    private TextView odczytanieopcji15;
    private TextView odczytanieopcji16;
    private TextView odczytanieopcji17;
    private TextView odczytanieopcji18;
    private TextView odczytanieopcji19;
    private TextView odczytanieopcji20;
    private TextView odczytanieopcji21;
    private TextView odczytanieopcji22;
    private TextView odczytanieopcji23;
    private TextView odczytaniedaty;
    private TextView odczytaniedaty2;
    private ScrollView scrollview;
    Button przycisk111;
    Calendar obecnadata = Calendar.getInstance();
    int MY_PERMISSIONS_REQUEST_READ_CONTACTS=0;
// Here, thisActivity is the current activity



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


            setContentView(R.layout.activity_gotowy_plan_treningowy);


            odczytanieopcji = (TextView) findViewById(R.id.opcja2);
            odczytanieopcji2 = (TextView) findViewById(R.id.opcja3);
            odczytanieopcji3 = (TextView) findViewById(R.id.opcja4);
            odczytanieopcji4 = (TextView) findViewById(R.id.opcja5);
            odczytanieopcji5 = (TextView) findViewById(R.id.opcja6);
            odczytanieopcji6 = (TextView) findViewById(R.id.opcja7);
            odczytanieopcji7 = (TextView) findViewById(R.id.opcja8);
            odczytanieopcji8 = (TextView) findViewById(R.id.opcja9);
            odczytanieopcji9 = (TextView) findViewById(R.id.opcja10);
            odczytanieopcji10 = (TextView) findViewById(R.id.opcja11);
            odczytanieopcji11 = (TextView) findViewById(R.id.opcja12);
            odczytanieopcji12 = (TextView) findViewById(R.id.opcja13);
            odczytanieopcji13 = (TextView) findViewById(R.id.opcja14);
            odczytanieopcji14 = (TextView) findViewById(R.id.opcja15);
            odczytanieopcji15 = (TextView) findViewById(R.id.opcja16);
            odczytanieopcji16 = (TextView) findViewById(R.id.opcja17);
            odczytanieopcji17 = (TextView) findViewById(R.id.opcja19);
            odczytanieopcji18 = (TextView) findViewById(R.id.opcja20);
            odczytanieopcji19 = (TextView) findViewById(R.id.opcja21);
            odczytanieopcji20 = (TextView) findViewById(R.id.opcja25);
            odczytanieopcji21 = (TextView) findViewById(R.id.opcja22);
            odczytanieopcji22 = (TextView) findViewById(R.id.opcja23);
            odczytanieopcji23 = (TextView) findViewById(R.id.opcja24);
            odczytaniedaty = (TextView) findViewById(R.id.data);
            odczytaniedaty2 = (TextView) findViewById(R.id.data1);
            scrollview = (ScrollView) findViewById(R.id.scrollView);
            przycisk111 = (Button) findViewById(R.id.screenshot);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build()); // zapewnia dostęp do zapisu plików np w galerii w wersjach =>24 SDK androida w innym wypadku wyrzuci wyjątek o braku mozliwosci dosdtepuy

        if (ContextCompat.checkSelfPermission(this, // warunki zapewniające dostęp do praw zapisu i odczytu plików w SDK od 24 androida trzeba ustalic programowo w kodzie, w manifescie działa lecz w wersjach nizszych niz 24
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {



            } else {


                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);


            }
        }


            int mRok = obecnadata.get(Calendar.YEAR);
            int mMiesiac = obecnadata.get(Calendar.MONTH);
            int mDzien = obecnadata.get(Calendar.DAY_OF_MONTH);
            obecnadata.set(mRok, mMiesiac, mDzien);
            odczytaniedaty.setText(mDzien + "-" + (mMiesiac + 1) + "-" + mRok);


            odczytaniedaty2.setText(mDzien + "-" + (mMiesiac + 4) + "-" + mRok);


            przycisk111.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                drukuj();
                Toast.makeText(GotowyPlanTreningowy.this,"Plan został zapisany!",Toast.LENGTH_LONG).show();




                }
            });

            ustalCwiczenieNogi();



        }


        public void ustalCwiczenieNogi () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("nw1",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nw2",GotowyPlanTreningowy.this,odczytanieopcji2);
                Dieta.setSharedPreferences("nw3",GotowyPlanTreningowy.this,odczytanieopcji3);


                wyswietlPlan();

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("nm1",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nm2",GotowyPlanTreningowy.this,odczytanieopcji2);
                Dieta.setSharedPreferences("nm3",GotowyPlanTreningowy.this,odczytanieopcji3);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("nm1a",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nw2a",GotowyPlanTreningowy.this,odczytanieopcji2);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("nw1b",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nw2b",GotowyPlanTreningowy.this,odczytanieopcji2);
                Dieta.setSharedPreferences("nw3b",GotowyPlanTreningowy.this,odczytanieopcji3);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("nm1b",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nm2b",GotowyPlanTreningowy.this,odczytanieopcji2);
                Dieta.setSharedPreferences("nm3b",GotowyPlanTreningowy.this,odczytanieopcji3);

                wyswietlPlan();


            } else {

                Dieta.setSharedPreferences("nw1c",GotowyPlanTreningowy.this,odczytanieopcji);
                Dieta.setSharedPreferences("nm2c",GotowyPlanTreningowy.this,odczytanieopcji2);
                Dieta.setSharedPreferences("nw3c",GotowyPlanTreningowy.this,odczytanieopcji3);

                wyswietlPlan();

            }


        }

        public void ustalCwiczenieKlatkaPiersiowa () {

            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("kw1",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("kw2",GotowyPlanTreningowy.this,odczytanieopcji5);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("km1",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("km2",GotowyPlanTreningowy.this,odczytanieopcji5);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("km1a",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("kw2a",GotowyPlanTreningowy.this,odczytanieopcji5);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("kw1b",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("kw2b",GotowyPlanTreningowy.this,odczytanieopcji5);
                Dieta.setSharedPreferences("kw3b",GotowyPlanTreningowy.this,odczytanieopcji6);
                Dieta.setSharedPreferences("kw4b",GotowyPlanTreningowy.this,odczytanieopcji7);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("km1b",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("km2b",GotowyPlanTreningowy.this,odczytanieopcji5);
                Dieta.setSharedPreferences("km3b",GotowyPlanTreningowy.this,odczytanieopcji6);


            } else {

                Dieta.setSharedPreferences("km1c",GotowyPlanTreningowy.this,odczytanieopcji4);
                Dieta.setSharedPreferences("kw2c",GotowyPlanTreningowy.this,odczytanieopcji5);
                Dieta.setSharedPreferences("km3c",GotowyPlanTreningowy.this,odczytanieopcji6);
                Dieta.setSharedPreferences("kw4c",GotowyPlanTreningowy.this,odczytanieopcji7);

            }


        }

        public void ustalCwiczenieBrzuch () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("bw1",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bw2",GotowyPlanTreningowy.this,odczytanieopcji9);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bm1",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bm2",GotowyPlanTreningowy.this,odczytanieopcji9);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("bm1a",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bw2a",GotowyPlanTreningowy.this,odczytanieopcji9);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("bw1b",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bw2b",GotowyPlanTreningowy.this,odczytanieopcji9);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bm1b",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bm2b",GotowyPlanTreningowy.this,odczytanieopcji9);


            } else {

                Dieta.setSharedPreferences("bw1c",GotowyPlanTreningowy.this,odczytanieopcji8);
                Dieta.setSharedPreferences("bm2c",GotowyPlanTreningowy.this,odczytanieopcji9);
                Dieta.setSharedPreferences("bw3c",GotowyPlanTreningowy.this,odczytanieopcji10);

            }

        }


        public void ustalCwiczenieBarki () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("baw1",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("baw2",GotowyPlanTreningowy.this,odczytanieopcji12);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bam1",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("bam2",GotowyPlanTreningowy.this,odczytanieopcji12);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("bam1a",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("baw2a",GotowyPlanTreningowy.this,odczytanieopcji12);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("baw1b",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("baw2b",GotowyPlanTreningowy.this,odczytanieopcji12);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bam1b",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("bam2b",GotowyPlanTreningowy.this,odczytanieopcji12);


            } else {

                Dieta.setSharedPreferences("bam1c",GotowyPlanTreningowy.this,odczytanieopcji11);
                Dieta.setSharedPreferences("baw2c",GotowyPlanTreningowy.this,odczytanieopcji12);
                Dieta.setSharedPreferences("bam3c",GotowyPlanTreningowy.this,odczytanieopcji13);


            }

        }


        public void ustalCwiczenieTriceps () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("tw1",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tw2",GotowyPlanTreningowy.this,odczytanieopcji15);




            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("tm1",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tm2",GotowyPlanTreningowy.this,odczytanieopcji15);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("tm1a",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tw2a",GotowyPlanTreningowy.this,odczytanieopcji15);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("tw1b",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tw2b",GotowyPlanTreningowy.this,odczytanieopcji15);
                Dieta.setSharedPreferences("tw3b",GotowyPlanTreningowy.this,odczytanieopcji16);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("tm1b",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tm2b",GotowyPlanTreningowy.this,odczytanieopcji15);
                Dieta.setSharedPreferences("tm3b",GotowyPlanTreningowy.this,odczytanieopcji16);

            } else {

                Dieta.setSharedPreferences("tw1c",GotowyPlanTreningowy.this,odczytanieopcji14);
                Dieta.setSharedPreferences("tm2c",GotowyPlanTreningowy.this,odczytanieopcji15);
                Dieta.setSharedPreferences("tw3c",GotowyPlanTreningowy.this,odczytanieopcji16);
            }


        }


        public void ustalCwiczeniePlecy () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("pw1",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pw2",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pw3",GotowyPlanTreningowy.this,odczytanieopcji19);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("pm1",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pm2",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pm3",GotowyPlanTreningowy.this,odczytanieopcji19);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("pm1a",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pw2a",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pm3a",GotowyPlanTreningowy.this,odczytanieopcji19);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("pw1b",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pw2b",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pw3b",GotowyPlanTreningowy.this,odczytanieopcji19);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("pm1b",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pm2b",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pm3b",GotowyPlanTreningowy.this,odczytanieopcji19);

            } else {

                Dieta.setSharedPreferences("pm1c",GotowyPlanTreningowy.this,odczytanieopcji17);
                Dieta.setSharedPreferences("pw2c",GotowyPlanTreningowy.this,odczytanieopcji18);
                Dieta.setSharedPreferences("pm3c",GotowyPlanTreningowy.this,odczytanieopcji19);
                Dieta.setSharedPreferences("pw4c",GotowyPlanTreningowy.this,odczytanieopcji20);

            }


        }


        public void ustalCwiczenieBiceps () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("bicw1",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicw2",GotowyPlanTreningowy.this,odczytanieopcji22);


            } else if ( PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bicm1",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicm2",GotowyPlanTreningowy.this,odczytanieopcji22);

            } else if (PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                Dieta.setSharedPreferences("bicm1a",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicw2a",GotowyPlanTreningowy.this,odczytanieopcji22);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                Dieta.setSharedPreferences("bicw1b",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicw2b",GotowyPlanTreningowy.this,odczytanieopcji22);
                Dieta.setSharedPreferences("bicw3b",GotowyPlanTreningowy.this,odczytanieopcji23);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                Dieta.setSharedPreferences("bicm1b",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicm2b",GotowyPlanTreningowy.this,odczytanieopcji22);
                Dieta.setSharedPreferences("bicm3b",GotowyPlanTreningowy.this,odczytanieopcji23);


            } else {

                Dieta.setSharedPreferences("bicw1c",GotowyPlanTreningowy.this,odczytanieopcji21);
                Dieta.setSharedPreferences("bicm2c",GotowyPlanTreningowy.this,odczytanieopcji22);
                Dieta.setSharedPreferences("bicw3c",GotowyPlanTreningowy.this,odczytanieopcji23);

            }

        }




    private void drukuj(){ //metoda drukujaca bitmape do jpg


        Bitmap bitmap = pobierzBitmapezWidoku(scrollview,scrollview.getChildAt(0).getHeight(),scrollview.getChildAt(0).getWidth());
        try {
            File defaultFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/PlanTrening"); //tworzymy folder na sd karcie
            if (!defaultFile.exists()) //jezeli nie istnieje to stworz folder
                defaultFile.mkdirs();

            String filename = "plantreningowy " + ".jpg"; //tak nazywac bedzie sie nasz plik
            File file = new File(defaultFile,filename); //tworzymy nowy plik  w folderze plantrening o nazwie plantreningowy
            if (file.exists()) { //jezeli plik istnieje to podmieniamy go na nowy
                file.delete();
                file = new File(defaultFile,filename);
            }

            FileOutputStream output = new FileOutputStream(file); //tworzenia strumienia wyjsciowego dla pliku okreslonego w obiekcie File
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output); // kompresja bitmapy do formatu png z jakoscią 100 i przekazanie do bufora wyjsciowego
            output.flush(); // oproznienie bufora wyjsciowego umozliwiajac zapis wszystkich zbuforowanych bajtów/znakow do ich miejsca przeznaczenia, w tym wypadku umozliwia zapis danych z widoku do pliku
            output.close(); // Plik zapisany, nastepuje zamkniecie bufora wyjsciowego bez mozliwosci ponownego otworzenia

            Uri uri =Uri.fromFile(file);
            Intent intencja = new Intent(Intent.ACTION_VIEW);
            intencja.setDataAndType(uri,"image/*");
            startActivity(intencja);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //create bitmap from the view
    private Bitmap pobierzBitmapezWidoku(View view,int height,int width) { // metoda która tworzy obraz z widoku w tym wypadku ze scrollview naszego xmla
        Bitmap bitmap = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Drawable bgDrawable =view.getBackground();
        if (bgDrawable!=null)
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }

    private void wyswietlPlan(){

        ustalCwiczenieKlatkaPiersiowa();
        ustalCwiczenieBrzuch();
        ustalCwiczenieBarki();
        ustalCwiczenieTriceps();
        ustalCwiczeniePlecy();
        ustalCwiczenieBiceps();


    }


    public void onBackPressed() {
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setTitle("Ostrzeżenie");
        alertdialog.setMessage("Jeżeli nie zapisałeś swojego planu, po wyjściu utracisz wszystkie dane na jego temat. Na pewno chcesz wyjść ? ");
        alertdialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                    GotowyPlanTreningowy.super.onBackPressed();
            }
        });

        alertdialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertdialog.create();
        alertdialog.show();
    }

}














