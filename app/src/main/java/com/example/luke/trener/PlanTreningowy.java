package com.example.luke.trener;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class PlanTreningowy extends AppCompatActivity {
    private Button przycisk;
    private AlertDialog alertDialog;
    TabliceOdpowiedzi odpowiedz111 = new TabliceOdpowiedzi();
    static int selected1;
    static int selected2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_treningowy);



    }

    public void preStartFormularza() { //utworzenie  formularza AlertDialog


        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this);
        TextView textView = new TextView(PlanTreningowy.this); // proces ustalenia stylu dla tytulu dialogu
        textView.setText("Po kliknięciu opcji 'DALEJ' zostaniesz przeniesiony do formularza zgłoszeniowego w którym czeka na ciebie 17 pytań. Na podstawie zaznaczonych odpowiedzi zostanie wygenerowana tobie spersonalizowana dieta na okres jednego tygodnia. Wygenerowany plan żywieniowy możesz zapisać a następnie przechowywać  na swoim urządzeniu. ");
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30, 20, 30, 20);
        dialog.setCustomTitle(textView); // ustawienie customowego tytulu


        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() { // reakcja na klikniecie przycisku Dalej... wywoluje w onClick
                        // kolejna metode, czyli kolejne okienko formularza... Schemat jest powtarzany tyle razy, ile jest pytan w calym formularzu
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz(); // start nastepnego okienka
            }
        });


        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() { // zakoncz dialog
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f); // ustalenie przyciemnienia tła wokol okienka alert dialog
        alertDialog.show();


    }



    public void startFormularz() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Proszę podać płeć.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz1(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {


                }

                if (i == 1) {


                }


            }


        });


        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz2();
            }
        });


        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz2() {

        final AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twoja aktywność fizyczna.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz2(), -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                selected1 = i;


                if (selected1 == 0 || selected1 == 1 && selected2 == 0) { //jezeli umiarkowana lub intensywna aktywnosc i trening z wolnymi to... warunki do wyboru poszczegolnych cwiczen

                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////

                    //schemat ustawiania poszczegolnych slow(cwiczen)
                    String[] Icwiczenienogiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogiwolne); // w tablicy typu string przechowujemy wylosowane slowa za pomoca metody z parametrem ktorym jest dana tablica na kttorej metoda operuje

                    Dieta.sendSharedPreferences("nw1", Icwiczenienogiw[0], PlanTreningowy.this);//tu ustalamy konkretne poszczegolne wylosowane slowo przypisujemy mu identyfikator, podajemy index z tablicy i ustawiamy kontest
                    // tak opakowane slowo bedzie moglo zostac odebrane w innej aktywnosci za pomoca klucza

                    Dieta.sendSharedPreferences("nw2", Icwiczenienogiw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nw3", Icwiczenienogiw[2], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkaw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkawolne);
                    Dieta.sendSharedPreferences("kw1", Icwiczenieklatkaw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("kw2", Icwiczenieklatkaw[1], PlanTreningowy.this);

                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchwolne);
                    Dieta.sendSharedPreferences("bw1", Icwiczeniebrzuchw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bw2", Icwiczeniebrzuchw[1], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkiwolne);
                    Dieta.sendSharedPreferences("baw1", Icwiczeniebarkiw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("baw2", Icwiczeniebarkiw[1], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepswolne);
                    Dieta.sendSharedPreferences("tw1", Icwiczenietricepsw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tw2", Icwiczenietricepsw[1], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecyw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecywolne);
                    Dieta.sendSharedPreferences("pw1", Icwiczenieplecyw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pw2", Icwiczenieplecyw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pw3", Icwiczenieplecyw[2], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepswolne);
                    Dieta.sendSharedPreferences("bicw1", Icwiczeniebicepsw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicw2", Icwiczeniebicepsw[1], PlanTreningowy.this);


                } else if ( selected1 == 1 && selected2 == 1) {  //jezeli umiarkowana lub intensywna aktywnosc i trening z maszynami to

                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////


                    String[] Icwiczenienogim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogimaszyny);
                    Dieta.sendSharedPreferences("nm1", Icwiczenienogim[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nm2", Icwiczenienogim[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nm3", Icwiczenienogim[2], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkam = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkamaszyny);
                    Dieta.sendSharedPreferences("km1", Icwiczenieklatkam[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("km2", Icwiczenieklatkam[1], PlanTreningowy.this);

                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchmaszyny);
                    Dieta.sendSharedPreferences("bm1", Icwiczeniebrzuchm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bm2", Icwiczeniebrzuchm[1], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkimaszyny);
                    Dieta.sendSharedPreferences("bam1", Icwiczeniebarkim[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bam2", Icwiczeniebarkim[1], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepsmaszyny);
                    Dieta.sendSharedPreferences("tm1", Icwiczenietricepsm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tm2", Icwiczenietricepsm[1], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecym = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecymaszyny);
                    Dieta.sendSharedPreferences("pm1", Icwiczenieplecym[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm2", Icwiczenieplecym[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm3", Icwiczenieplecym[2], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepsmaszyny);
                    Dieta.sendSharedPreferences("bicm1", Icwiczeniebicepsm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicm2", Icwiczeniebicepsm[1], PlanTreningowy.this);


                } else if ( selected1 == 1 && selected2 == 2) { //jezeli umiarkowana lub intensywna aktywnosc i trening zroznicowany

                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////


                    String[] Icwiczenienogim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogimaszyny);
                    Dieta.sendSharedPreferences("nm1a", Icwiczenienogim[0], PlanTreningowy.this);

                    String[] IIcwiczenienogiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogiwolne);
                    Dieta.sendSharedPreferences("nw2a", IIcwiczenienogiw[1], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkam = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkamaszyny);
                    Dieta.sendSharedPreferences("km1a", Icwiczenieklatkam[0], PlanTreningowy.this);

                    String[] IIcwiczenieklatkaw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkawolne);
                    Dieta.sendSharedPreferences("kw2a", IIcwiczenieklatkaw[1], PlanTreningowy.this);

                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchmaszyny);
                    Dieta.sendSharedPreferences("bm1a", Icwiczeniebrzuchm[0], PlanTreningowy.this);

                    String[] IIcwiczeniebrzuchw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchwolne);
                    Dieta.sendSharedPreferences("bw2a", IIcwiczeniebrzuchw[1], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkimaszyny);
                    Dieta.sendSharedPreferences("bam1a", Icwiczeniebarkim[0], PlanTreningowy.this);

                    String[] IIcwiczeniebarkiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkiwolne);
                    Dieta.sendSharedPreferences("baw2a", IIcwiczeniebarkiw[1], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepsmaszyny);
                    Dieta.sendSharedPreferences("tm1a", Icwiczenietricepsm[0], PlanTreningowy.this);

                    String[] IIcwiczenietricepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepswolne);
                    Dieta.sendSharedPreferences("tw2a", IIcwiczenietricepsw[1], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecym = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecymaszyny);
                    Dieta.sendSharedPreferences("pm1a", Icwiczenieplecym[0], PlanTreningowy.this);

                    String[] IIcwiczenieplecyw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecywolne);
                    Dieta.sendSharedPreferences("pw2a", IIcwiczenieplecyw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm3a", Icwiczenieplecym[1], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepsmaszyny);
                    Dieta.sendSharedPreferences("bicm1a", Icwiczeniebicepsm[0], PlanTreningowy.this);

                    String[] IIcwiczeniebicepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepswolne);
                    Dieta.sendSharedPreferences("bicw2a", IIcwiczeniebicepsw[1], PlanTreningowy.this);


                } else if (selected1 == 2 && selected2 == 0) { // jezeli bardzo wysoka intensywnosc i wolne ciezary to


                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////


                    String[] Icwiczenienogiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogiwolne);
                    Dieta.sendSharedPreferences("nw1b", Icwiczenienogiw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nw2b", Icwiczenienogiw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nw3b", Icwiczenienogiw[2], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkaw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkawolne);
                    Dieta.sendSharedPreferences("kw1b", Icwiczenieklatkaw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("kw2b", Icwiczenieklatkaw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("kw3b", Icwiczenieklatkaw[2], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("kw4b", Icwiczenieklatkaw[3], PlanTreningowy.this);

                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchwolne);
                    Dieta.sendSharedPreferences("bw1b", Icwiczeniebrzuchw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bw2b", Icwiczeniebrzuchw[1], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkiwolne);
                    Dieta.sendSharedPreferences("baw1b", Icwiczeniebarkiw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("baw2b", Icwiczeniebarkiw[1], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepswolne);
                    Dieta.sendSharedPreferences("tw1b", Icwiczenietricepsw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tw2b", Icwiczenietricepsw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tw3b", Icwiczenietricepsw[2], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecyw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecywolne);
                    Dieta.sendSharedPreferences("pw1b", Icwiczenieplecyw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pw2b", Icwiczenieplecyw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pw3b", Icwiczenieplecyw[2], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepswolne);
                    Dieta.sendSharedPreferences("bicw1b", Icwiczeniebicepsw[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicw2b", Icwiczeniebicepsw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicw3b", Icwiczeniebicepsw[2], PlanTreningowy.this);


                } else if (selected1 == 2 && selected2 == 1) { // jezeli bardzo wysoka intensywnosc i maszyny to
                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////


                    String[] Icwiczenienogim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogimaszyny);
                    Dieta.sendSharedPreferences("nm1b", Icwiczenienogim[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nm2b", Icwiczenienogim[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nm3b", Icwiczenienogim[2], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkam = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkamaszyny);
                    Dieta.sendSharedPreferences("km1b", Icwiczenieklatkam[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("km2b", Icwiczenieklatkam[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("km3b", Icwiczenieklatkam[2], PlanTreningowy.this);


                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchmaszyny);
                    Dieta.sendSharedPreferences("bm1b", Icwiczeniebrzuchm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bm2b", Icwiczeniebrzuchm[1], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkimaszyny);
                    Dieta.sendSharedPreferences("bam1b", Icwiczeniebarkim[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bam2b", Icwiczeniebarkim[1], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepsmaszyny);
                    Dieta.sendSharedPreferences("tm1b", Icwiczenietricepsm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tm2b", Icwiczenietricepsm[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tm3b", Icwiczenietricepsm[2], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecym = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecymaszyny);
                    Dieta.sendSharedPreferences("pm1b", Icwiczenieplecym[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm2b", Icwiczenieplecym[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm3b", Icwiczenieplecym[2], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepsmaszyny);
                    Dieta.sendSharedPreferences("bicm1b", Icwiczeniebicepsm[0], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicm2b", Icwiczeniebicepsm[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicm3b", Icwiczeniebicepsm[2], PlanTreningowy.this);


                } else if (selected1 == 2 && selected2 == 2) { // jezeli bardzo wysoka intensywnosc i zroznicowany trening

                    String[] Icwiczenienogiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogiwolne);
                    Dieta.sendSharedPreferences("nw1c", Icwiczenienogiw[0], PlanTreningowy.this);

                    String[] IIcwiczenienogim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawnogimaszyny);
                    Dieta.sendSharedPreferences("nm2c", IIcwiczenienogim[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("nw3c", Icwiczenienogiw[1], PlanTreningowy.this);


                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String[] Icwiczenieklatkam = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkamaszyny);
                    Dieta.sendSharedPreferences("km1c", Icwiczenieklatkam[0], PlanTreningowy.this);

                    String[] IIcwiczenieklatkaw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawklatkawolne);
                    Dieta.sendSharedPreferences("kw2c", IIcwiczenieklatkaw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("km3c", Icwiczenieklatkam[2], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("kw4c", IIcwiczenieklatkaw[3], PlanTreningowy.this);


                    /////////////////////BRZUCH////////////////////////////////


                    String[] Icwiczeniebrzuchw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchwolne);
                    Dieta.sendSharedPreferences("bw1c", Icwiczeniebrzuchw[0], PlanTreningowy.this);

                    String[] IIcwiczeniebrzuchm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbrzuchmaszyny);
                    Dieta.sendSharedPreferences("bm2c", IIcwiczeniebrzuchm[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bw3c", Icwiczeniebrzuchw[2], PlanTreningowy.this);

                    /////////////////////BARKI////////////////////////////////


                    String[] Icwiczeniebarkim = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkimaszyny);
                    Dieta.sendSharedPreferences("bam1c", Icwiczeniebarkim[0], PlanTreningowy.this);

                    String[] IIcwiczeniebarkiw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbarkiwolne);
                    Dieta.sendSharedPreferences("baw2c", IIcwiczeniebarkiw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bam3c", Icwiczeniebarkim[2], PlanTreningowy.this);

                    /////////////////////TRICEPS////////////////////////////////

                    String[] Icwiczenietricepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepswolne);
                    Dieta.sendSharedPreferences("tw1c", Icwiczenietricepsw[0], PlanTreningowy.this);

                    String[] IIcwiczenietricepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawtricepsmaszyny);
                    Dieta.sendSharedPreferences("tm2c", IIcwiczenietricepsm[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("tw3c", Icwiczenietricepsw[2], PlanTreningowy.this);


                    ////////////////////PLECY////////////////////////////////

                    String[] Icwiczenieplecym = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecymaszyny);
                    Dieta.sendSharedPreferences("pm1c", Icwiczenieplecym[0], PlanTreningowy.this);

                    String[] IIcwiczenieplecyw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawplecywolne);
                    Dieta.sendSharedPreferences("pw2c", IIcwiczenieplecyw[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pm3c", Icwiczenieplecym[2], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("pw4c", IIcwiczenieplecyw[3], PlanTreningowy.this);

                    /////////////////////BICEPS////////////////////////////////

                    String[] Icwiczeniebicepsw = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepswolne);
                    Dieta.sendSharedPreferences("bicw1c", Icwiczeniebicepsw[0], PlanTreningowy.this);

                    String[] IIcwiczeniebicepsm = wylosujCwiczenieBezPowtorzen(TabliceCwiczen.zestawbicepsmaszyny);
                    Dieta.sendSharedPreferences("bicm2c", IIcwiczeniebicepsm[1], PlanTreningowy.this);

                    Dieta.sendSharedPreferences("bicw3c", Icwiczeniebicepsw[2], PlanTreningowy.this);


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz3();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz3() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twój przedział wiekowy.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz3(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {


                }
                if (i == 1) {


                }
                if (i == 2) {

                }
                if (i == 3) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz4();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz4() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jakie jest twoje BMI( Wskaźnik masy ciała) ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz4(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }
                if (i == 3) {

                }
                if (i == 4) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz5();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz5() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Potrafisz określić poziom swojej tkanki tłuszczowej ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz5(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }
                if (i == 3) {

                }
                if (i == 4) {

                }
                if (i == 5) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz6();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz6() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twój staż treningowy.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz6(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }

            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz7();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz7() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile razy w tygodniu zamierzasz trenować ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz7(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }

            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz8();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz8() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Rozwój jakich mięśni jest dla ciebie najważniejszy ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz8(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }https://ganjafarmer.com.pl/494-easy-sativa.html#
                if (i == 1) {

                }
                if (i == 2) {

                }
                if (i == 3) {


                }

            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz9();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }


    public void startFormularz9() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Masz jakiekolwiek przeciwwskazania do" + " " + "wykonywania poszczególnych ćwiczeń ?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz9(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz10();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz10() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jaki rodzaj treningu preferujesz?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz10(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selected2 = i;

                if (selected2 == 0) {

                }
                if (selected2 == 1) {

                }
                if (selected2 == 2) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz11();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz11() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile czasu zamierzasz poświęcić na trening w danym dniu?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz11(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularz12();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz12() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Czy jesteś w stanie wykonywać ćwiczenia z wykorzystaniem" + " " + "własnego ciężaru ciała?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz12(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz13();

            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz13() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy zamierzasz stosować dietę w treningu siłowym?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz13(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                startFormularz14();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz14() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Na jaki rodzaj treningu aerobowego kładziesz" + " " + "największy nacisk? ");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz14(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                startFormularz15();

            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }


    public void startFormularz15() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Na jaki rodzaj treningu siłowego kładziesz największy nacisk? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz15(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {

                }

                if (i == 3) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz16();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }

    public void startFormularz16() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy zamierzasz uczęszczać na zajęcia fitness? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz16(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                startFormularz17();


            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }


    public void startFormularz17() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jaki trening cardio preferujesz? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz17(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (i == 0) {

                }
                if (i == 1) {

                }
                if (i == 2) {


                }


            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ProgressDialog1();




            }
        });

        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();


            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }


    public static String[] wylosujCwiczenieBezPowtorzen(String[] tab) {


        Random random = new Random(); // tworzymy obiekt typu random do wylosowania randomowego cwiczenia
        List<String> lista = new ArrayList<String>(Arrays.asList(tab)); // musimy utworzyc liste typu arraylist, a nastepnie przekonwertowac ja na
        // tablice jednowymiarowa, gdyz na takich tablicach cwiczen operujemy w osobnym
        // pliku, wszystko po to aby moc dynamicznie usuwac poszczegolne slowa
        // w danym kroku z listy tablicowej, gdyz w tablicach jednowymiarowyc
        // w tym przypadku by to nie zadzialalo

        int[] index = new int[4]; // tworzymy 3 elementowa pusta tablice typu int do przechowywania poszczegolnych indexow z tablic cwiczen
        String[] wylosowaneslowo = new String[4];// tworzymy 3 elementowa tablice typu string ktora przechowuje poszczegolne wylosowane slowa


        for (int i = 0; i < index.length; i++) {

            if (lista.size() > 0) {
                index[i] = random.nextInt(lista.size());// w kazdym poszczegolnym indeksie tablicy przechowujemy pobrany indeks z tablicy cwiczen
                wylosowaneslowo[i] = lista.get(index[i]);// w kazdym poszczegolnym indeksie tablicy string, przechowujemy konkretne słowo wylosowane za
                lista.remove(index[i]);                    // pomoca obiektu random


            }
        }

        lista.toArray(new String[0]); // na koncu znowu konwertujemy nasza liste na zwykla tablice


        // zwracamy tablice wylosowanych slow


        return wylosowaneslowo;


    }


    public  void ProgressDialog1(){
        final ProgressDialog progress1 = new ProgressDialog(PlanTreningowy.this);
        progress1.setTitle("Proszę czekać...");
        progress1.setMessage("Trwa generowanie raportu...");
        progress1.show();







        Handler handler1 = new Handler(); // utworzenie handlera aby powiazac watek poboczny z głównym
        handler1.postDelayed(new Runnable() { // do parametru metody postdelayed handlera przekazujemy obiekt runnable w ktorym startujemy nasz watek, aby to zrobic musimy zaimplementowac metode z interfejsu runnable w ktorej mowimy co ma sie stac./...
            @Override
            public void run() {
                progress1.cancel(); // zamkniecie watku po jego uruchomieniu
                Intent intent1 = new Intent(PlanTreningowy.this, GotowyPlanTreningowy.class);
                startActivity(intent1);

            }
        }, 5000); // tutaj za pomoca metody postDelayed mowimy watkowi aby zostal wykonany po czasie 4sekund
    }


}


















