package com.example.luke.trener;


import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dieta extends PlanTreningowy {
    static int zaznaczonyindex;
    static int zaznaczonyindex2;
    private Button przycisk;
    private AlertDialog alertDialog;
    TabliceOdpowiedzi odpowiedz111 = new TabliceOdpowiedzi();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);




    }

    public void startFormularza() { // tu zaczyna sie start formularza ALertDialog


        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this);
        TextView textView = new TextView(Dieta.this);
        textView.setText("Po kliknięciu opcji 'DALEJ' zostaniesz przeniesiony do formularza zgłoszeniowego w którym czeka na ciebie 12 pytań. Na podstawie zaznaczonych odpowiedzi zostanie wygenerowana tobie spersonalizowana dieta na okres jednego tygodnia. Wygenerowany plan żywieniowy możesz zapisać a następnie przechowywać  na swoim urządzeniu. ");
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.CENTER);
        textView.setPadding(30, 20, 30, 20);
        dialog.setCustomTitle(textView);


        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() { // w przypadku nacisniecia dalej przechodzimy do kolejnego pytania
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularzD(); // wywolanie kolejnego pytania / okienka alertDialog
            }
        });


        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) { //cofniecie

                alertDialog.dismiss(); // wylaczenie alert dialogu

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f);
        alertDialog.show();


    }


    private void startFormularzD() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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

                startFormularzD2();
            }
        });


        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.getWindow().setDimAmount(0.85f); // ustawia przyciemnienie tła podczas wyskoczenia dialogu
        alertDialog.show();


    }

    private void startFormularzD2() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Dlaczego potrzebujesz diety?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz18(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                zaznaczonyindex = i; // ustalenie kliknietego pola na alert dialogu ...  uzywam zmiennej statycznej dlatego aby móc się odwołać do tego konkretnego kliknietego pola
                                    // w drugiej aktywnosci i ustalic warunki wyswietlenia danego slowa


                ///////////////////Poniedziałek/////////////////////////////////////////////////////////////

                //ulepszona wersja ponizszego schematu ustalania slow z tablic znajduje sie w PlanTreningowy.java
                if (zaznaczonyindex == 0) {
                    String[] Iposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekredukcja);
                    //w zmiennej tablicowej przechowujemy wylosowane slowa, z tablicy podanej w parametrze metody
                    sendSharedPreferences("a1", Iposilekredukcja[0], Dieta.this);
                    //tu ustalamy konkretne poszczegolne wylosowane slowo przypisujemy mu identyfikator, podajemy index z tablicy i ustawiamy kontest
                    // tak opakowane slowo bedzie moglo zostac odebrane w innej aktywnosci za pomoca klucza

                    String[] IIposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekredukcja);
                    sendSharedPreferences("a2", IIposilekredukcja[0], Dieta.this);

                    String[] IIIposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("a3", IIIposilekredukcja[0], Dieta.this);

                    String[] IVposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekredukcja);
                    sendSharedPreferences("a4", IVposilekredukcja[0], Dieta.this);

                    String[] Vposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekredukcja);
                    sendSharedPreferences("a5", Vposilekredukcja[0], Dieta.this);


                    ///////////////////WTOREK/////////////////////////////////////////////////////////////

                    String[] Iposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekredukcja);
                    sendSharedPreferences("b1", Iposilekredukcjawt[0], Dieta.this);

                    String[] IIposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekredukcja);
                    sendSharedPreferences("b2", IIposilekredukcjawt[0], Dieta.this);

                    String[] IIIposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("b3", IIIposilekredukcjawt[0], Dieta.this);

                    String[] IVposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekredukcja);
                    sendSharedPreferences("b4", IVposilekredukcjawt[0], Dieta.this);

                    String[] Vposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekredukcja);
                    sendSharedPreferences("b5", Vposilekredukcjawt[0], Dieta.this);

                    ///////////////////SRODA/////////////////////////////////////////////////////////////

                    String[] Iposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekredukcja);
                    sendSharedPreferences("c1", Iposilekredukcjasr[0], Dieta.this);

                    String[] IIposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekredukcja);
                    sendSharedPreferences("c2", IIposilekredukcjasr[0], Dieta.this);

                    String[] IIIposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("c3", IIIposilekredukcjasr[0], Dieta.this);

                    String[] IVposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekredukcja);
                    sendSharedPreferences("c4", IVposilekredukcjasr[0], Dieta.this);

                    String[] Vposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekredukcja);
                    sendSharedPreferences("c5", Vposilekredukcjasr[0], Dieta.this);

                    ///////////////////CZWARTEK/////////////////////////////////////////////////////////////

                    String[] Iposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekredukcja);
                    sendSharedPreferences("d1", Iposilekredukcjacz[0], Dieta.this);

                    String[] IIposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekredukcja);
                    sendSharedPreferences("d2", IIposilekredukcjacz[0], Dieta.this);

                    String[] IIIposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("d3", IIIposilekredukcjacz[0], Dieta.this);

                    String[] IVposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekredukcja);
                    sendSharedPreferences("d4", IVposilekredukcjacz[0], Dieta.this);

                    String[] Vposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekredukcja);
                    sendSharedPreferences("d5", Vposilekredukcjacz[0], Dieta.this);

                    ///////////////////PIATEK/////////////////////////////////////////////////////////////

                    String[] Iposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekredukcja);
                    sendSharedPreferences("e1", Iposilekredukcjapt[0], Dieta.this);

                    String[] IIposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekredukcja);
                    sendSharedPreferences("e2", IIposilekredukcjapt[0], Dieta.this);

                    String[] IIIposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("e3", IIIposilekredukcjapt[0], Dieta.this);

                    String[] IVposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekredukcja);
                    sendSharedPreferences("e4", IVposilekredukcjapt[0], Dieta.this);

                    String[] Vposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekredukcja);
                    sendSharedPreferences("e5", Vposilekredukcjapt[0], Dieta.this);


                } else if (zaznaczonyindex == 1) {

                    ///////////////P[ONIEDZIALEK////////////////////////////////////////////////////

                    String[] Iposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("a6", Iposilekmasa[0], Dieta.this);

                    String[] IIposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekmasa);
                    sendSharedPreferences("a7", IIposilekmasa[0], Dieta.this);

                    String[] IIIposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekmasa);
                    sendSharedPreferences("a8", IIIposilekmasa[0], Dieta.this);

                    String[] IVposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekmasa);
                    sendSharedPreferences("a9", IVposilekmasa[0], Dieta.this);

                    String[] Vposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekmasa);
                    sendSharedPreferences("a10", Vposilekmasa[0], Dieta.this);

                    ///////////////WTOREK////////////////////////////////////////////////////

                    String[] Iposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("b6", Iposilekmasawt[0], Dieta.this);

                    String[] IIposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekmasa);
                    sendSharedPreferences("b7", IIposilekmasawt[0], Dieta.this);

                    String[] IIIposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekmasa);
                    sendSharedPreferences("b8", IIIposilekmasawt[0], Dieta.this);

                    String[] IVposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekmasa);
                    sendSharedPreferences("b9", IVposilekmasawt[0], Dieta.this);

                    String[] Vposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekmasa);
                    sendSharedPreferences("b10", Vposilekmasawt[0], Dieta.this);

                    ///////////////SRODA////////////////////////////////////////////////////

                    String[] Iposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("c6", Iposilekmasasr[0], Dieta.this);

                    String[] IIposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekmasa);
                    sendSharedPreferences("c7", IIposilekmasasr[0], Dieta.this);

                    String[] IIIposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekmasa);
                    sendSharedPreferences("c8", IIIposilekmasasr[0], Dieta.this);

                    String[] IVposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekmasa);
                    sendSharedPreferences("c9", IVposilekmasasr[0], Dieta.this);

                    String[] Vposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekmasa);
                    sendSharedPreferences("c10", Vposilekmasasr[0], Dieta.this);


                    ///////////////CZWARTEK////////////////////////////////////////////////////

                    String[] Iposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("d6", Iposilekmasacz[0], Dieta.this);

                    String[] IIposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekmasa);
                    sendSharedPreferences("d7", IIposilekmasacz[0], Dieta.this);

                    String[] IIIposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekmasa);
                    sendSharedPreferences("d8", IIIposilekmasacz[0], Dieta.this);

                    String[] IVposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekmasa);
                    sendSharedPreferences("d9", IVposilekmasacz[0], Dieta.this);

                    String[] Vposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekmasa);
                    sendSharedPreferences("d10", Vposilekmasacz[0], Dieta.this);

                    ///////////////PIATEK////////////////////////////////////////////////////

                    String[] Iposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("e6", Iposilekmasapt[0], Dieta.this);

                    String[] IIposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekmasa);
                    sendSharedPreferences("e7", IIposilekmasapt[0], Dieta.this);

                    String[] IIIposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekmasa);
                    sendSharedPreferences("e8", IIIposilekmasapt[0], Dieta.this);

                    String[] IVposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekmasa);
                    sendSharedPreferences("e9", IVposilekmasapt[0], Dieta.this);

                    String[] Vposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekmasa);
                    sendSharedPreferences("e10", Vposilekmasapt[0], Dieta.this);


                } else if (zaznaczonyindex == 2) {

                    //////////////////PONIEDZIALEK//////////////////////////////////////////////

                    String[] Iposilekmasa = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("a11", Iposilekmasa[0], Dieta.this);

                    String[] IIposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("a12", IIposilekstabilizacja[0], Dieta.this);

                    String[] IIIposilekredukcja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("a13", IIIposilekredukcja[0], Dieta.this);

                    String[] IVposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("a14", IVposilekstabilizacja[0], Dieta.this);

                    String[] Vposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("a15", Vposilekstabilizacja[0], Dieta.this);

                    //////////////////WTOREK//////////////////////////////////////////////

                    String[] Iposilekmasawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("b11", Iposilekmasawt[0], Dieta.this);

                    String[] IIposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("b12", IIposilekstabilizacjawt[0], Dieta.this);

                    String[] IIIposilekredukcjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("b13", IIIposilekredukcjawt[0], Dieta.this);

                    String[] IVposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("b14", IVposilekstabilizacjawt[0], Dieta.this);

                    String[] Vposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("b15", Vposilekstabilizacjawt[0], Dieta.this);


                    //////////////////SRODA//////////////////////////////////////////////

                    String[] Iposilekmasasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("c11", Iposilekmasasr[0], Dieta.this);

                    String[] IIposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("c12", IIposilekstabilizacjasr[0], Dieta.this);

                    String[] IIIposilekredukcjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("c13", IIIposilekredukcjasr[0], Dieta.this);

                    String[] IVposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("c14", IVposilekstabilizacjasr[0], Dieta.this);

                    String[] Vposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("c15", Vposilekstabilizacjasr[0], Dieta.this);

                    //////////////////CZWARTEK//////////////////////////////////////////////

                    String[] Iposilekmasacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("d11", Iposilekmasacz[0], Dieta.this);

                    String[] IIposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("d12", IIposilekstabilizacjacz[0], Dieta.this);

                    String[] IIIposilekredukcjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("d13", IIIposilekredukcjacz[0], Dieta.this);

                    String[] IVposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("d14", IVposilekstabilizacjacz[0], Dieta.this);

                    String[] Vposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("d15", Vposilekstabilizacjacz[0], Dieta.this);

                    //////////////////PIATEK//////////////////////////////////////////////

                    String[] Iposilekmasapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekmasa);
                    sendSharedPreferences("e11", Iposilekmasapt[0], Dieta.this);

                    String[] IIposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("e12", IIposilekstabilizacjapt[0], Dieta.this);

                    String[] IIIposilekredukcjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekredukcja);
                    sendSharedPreferences("e13", IIIposilekredukcjapt[0], Dieta.this);

                    String[] IVposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("e14", IVposilekstabilizacjapt[0], Dieta.this);

                    String[] Vposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("e15", Vposilekstabilizacjapt[0], Dieta.this);


                } else {

                    /////////////////PONIEDZIALEK//////////////////////////////////////////////////

                    String[] Iposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekstabilizacja);
                    sendSharedPreferences("a16", Iposilekstabilizacja[0], Dieta.this);

                    String[] IIposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("a17", IIposilekstabilizacja[0], Dieta.this);

                    String[] IIIposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekstabilizacja);
                    sendSharedPreferences("a18", IIIposilekstabilizacja[0], Dieta.this);

                    String[] IVposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("a19", IVposilekstabilizacja[0], Dieta.this);

                    String[] Vposilekstabilizacja = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("a20", Vposilekstabilizacja[0], Dieta.this);

                    /////////////////WTOREK//////////////////////////////////////////////////

                    String[] Iposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekstabilizacja);
                    sendSharedPreferences("b16", Iposilekstabilizacjawt[0], Dieta.this);

                    String[] IIposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("b17", IIposilekstabilizacjawt[0], Dieta.this);

                    String[] IIIposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekstabilizacja);
                    sendSharedPreferences("b18", IIIposilekstabilizacjawt[0], Dieta.this);

                    String[] IVposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("b19", IVposilekstabilizacjawt[0], Dieta.this);

                    String[] Vposilekstabilizacjawt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("b20", Vposilekstabilizacjawt[0], Dieta.this);

                    /////////////////SRODA//////////////////////////////////////////////////

                    String[] Iposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekstabilizacja);
                    sendSharedPreferences("c16", Iposilekstabilizacjasr[0], Dieta.this);

                    String[] IIposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("c17", IIposilekstabilizacjasr[0], Dieta.this);

                    String[] IIIposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekstabilizacja);
                    sendSharedPreferences("c18", IIIposilekstabilizacjasr[0], Dieta.this);

                    String[] IVposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("c19", IVposilekstabilizacjasr[0], Dieta.this);

                    String[] Vposilekstabilizacjasr = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("c20", Vposilekstabilizacjasr[0], Dieta.this);


                    /////////////////CZWARTEK//////////////////////////////////////////////////

                    String[] Iposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekstabilizacja);
                    sendSharedPreferences("d16", Iposilekstabilizacjacz[0], Dieta.this);

                    String[] IIposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("d17", IIposilekstabilizacjacz[0], Dieta.this);

                    String[] IIIposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekstabilizacja);
                    sendSharedPreferences("d18", IIIposilekstabilizacjacz[0], Dieta.this);

                    String[] IVposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("d19", IVposilekstabilizacjacz[0], Dieta.this);

                    String[] Vposilekstabilizacjacz = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("d20", Vposilekstabilizacjacz[0], Dieta.this);

                    /////////////////PIATEK//////////////////////////////////////////////////

                    String[] Iposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Iposilekstabilizacja);
                    sendSharedPreferences("e16", Iposilekstabilizacjapt[0], Dieta.this);

                    String[] IIposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIposilekstabilizacja);
                    sendSharedPreferences("e17", IIposilekstabilizacjapt[0], Dieta.this);

                    String[] IIIposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IIIposilekstabilizacja);
                    sendSharedPreferences("e18", IIIposilekstabilizacjapt[0], Dieta.this);

                    String[] IVposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.IVpolsilekstabilizacja);
                    sendSharedPreferences("e19", IVposilekstabilizacjapt[0], Dieta.this);

                    String[] Vposilekstabilizacjapt = wylosujPosilekBezPowtorzen(DietaPozywienie.Vposilekstabilizacja);
                    sendSharedPreferences("e20", Vposilekstabilizacjapt[0], Dieta.this);


                }


            }


        });


        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularzD3();

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

    private void startFormularzD3() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Potrafisz określić swoje BMI ( wskaźnik masy ciała ) ?");
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
                startFormularzD4();

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

    private void startFormularzD4() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile razy w tygodniu zamierzasz ćwiczyć?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz19(), 0, new DialogInterface.OnClickListener() {
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

                startFormularzD5();

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

    private void startFormularzD5() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this);// builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this); // proces ustalania stylu dla textview
        textView.setText("Czy zamierzasz stosować w swojej diecie odżywki" + " " + "oraz  suplementy diety?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz20(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD6();

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

    private void startFormularzD6() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Jeżeli uwzględniasz w swojej diecie suplementy, to jaką" + " " + " kwotę zamierzasz na nie przeznaczyć?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz21(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD7();

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

    private void startFormularzD7() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy narzekasz na senność i spadki energii w ciągu dnia?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz23(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD8();

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

    private void startFormularzD8() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Ile zamierzasz wydać na produkty spożywcze w ciągu" + " " + "miesiąca?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);


        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz22(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD9();

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

    private void startFormularzD9() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jesteś w stanie przestrzegać diety rygorystycznie?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz23(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD10();

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

    private void startFormularzD10() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Ile czasu jesteś w stanie poświęcić na przygotowanie" + " " + "posiłków?");
        textView.setPadding(20, 10, 20, 10);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz24(), 0, new DialogInterface.OnClickListener() {
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
                startFormularzD11();

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

    private void startFormularzD11() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("O której przeważnie kładziesz się spać?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz25(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                zaznaczonyindex2 = i;

                if (zaznaczonyindex2 == 0) {
                    // ustalenie godziny dla pola pod indeksem 0, //poniedzialek//
                    String[] danagodzina22 = ustalGodzinyPosilkow(DietaPozywienie.godzinyposilkow22);
                    sendSharedPreferences("s22a", danagodzina22[0], Dieta.this);
                    sendSharedPreferences("s22b", danagodzina22[1], Dieta.this);
                    sendSharedPreferences("s22c", danagodzina22[2], Dieta.this);
                    sendSharedPreferences("s22d", danagodzina22[3], Dieta.this);
                    sendSharedPreferences("s22e", danagodzina22[4], Dieta.this);
                                            //WTOREK////
                    sendSharedPreferences("s22f", danagodzina22[0], Dieta.this);
                    sendSharedPreferences("s22g", danagodzina22[1], Dieta.this);
                    sendSharedPreferences("s22h", danagodzina22[2], Dieta.this);
                    sendSharedPreferences("s22i", danagodzina22[3], Dieta.this);
                    sendSharedPreferences("s22j", danagodzina22[4], Dieta.this);
                                                //SRODA///
                    sendSharedPreferences("s22k", danagodzina22[0], Dieta.this);
                    sendSharedPreferences("s22l", danagodzina22[1], Dieta.this);
                    sendSharedPreferences("s22m", danagodzina22[2], Dieta.this);
                    sendSharedPreferences("s22n", danagodzina22[3], Dieta.this);
                    sendSharedPreferences("s22o", danagodzina22[4], Dieta.this);
                                                //CZWARTEK/////
                    sendSharedPreferences("s22p", danagodzina22[0], Dieta.this);
                    sendSharedPreferences("s22r", danagodzina22[1], Dieta.this);
                    sendSharedPreferences("s22s", danagodzina22[2], Dieta.this);
                    sendSharedPreferences("s22t", danagodzina22[3], Dieta.this);
                    sendSharedPreferences("s22u", danagodzina22[4], Dieta.this);
                                                //PIATEK////
                    sendSharedPreferences("s22w", danagodzina22[0], Dieta.this);
                    sendSharedPreferences("s22x", danagodzina22[1], Dieta.this);
                    sendSharedPreferences("s22y", danagodzina22[2], Dieta.this);
                    sendSharedPreferences("s22z", danagodzina22[3], Dieta.this);
                    sendSharedPreferences("s22zz", danagodzina22[4], Dieta.this);


                }
                if (zaznaczonyindex2 == 1) {

                    String[] danagodzina23 = ustalGodzinyPosilkow(DietaPozywienie.godzinyposilkow23);
                    sendSharedPreferences("s23a", danagodzina23[0], Dieta.this);
                    sendSharedPreferences("s23b", danagodzina23[1], Dieta.this);
                    sendSharedPreferences("s23c", danagodzina23[2], Dieta.this);
                    sendSharedPreferences("s23d", danagodzina23[3], Dieta.this);
                    sendSharedPreferences("s23e", danagodzina23[4], Dieta.this);

                    sendSharedPreferences("s23f", danagodzina23[0], Dieta.this);
                    sendSharedPreferences("s23g", danagodzina23[1], Dieta.this);
                    sendSharedPreferences("s23h", danagodzina23[2], Dieta.this);
                    sendSharedPreferences("s23i", danagodzina23[3], Dieta.this);
                    sendSharedPreferences("s23j", danagodzina23[4], Dieta.this);

                    sendSharedPreferences("s23k", danagodzina23[0], Dieta.this);
                    sendSharedPreferences("s23l", danagodzina23[1], Dieta.this);
                    sendSharedPreferences("s23m", danagodzina23[2], Dieta.this);
                    sendSharedPreferences("s23n", danagodzina23[3], Dieta.this);
                    sendSharedPreferences("s23o", danagodzina23[4], Dieta.this);

                    sendSharedPreferences("s23p", danagodzina23[0], Dieta.this);
                    sendSharedPreferences("s23r", danagodzina23[1], Dieta.this);
                    sendSharedPreferences("s23s", danagodzina23[2], Dieta.this);
                    sendSharedPreferences("s23t", danagodzina23[3], Dieta.this);
                    sendSharedPreferences("s23u", danagodzina23[4], Dieta.this);

                    sendSharedPreferences("s23w", danagodzina23[0], Dieta.this);
                    sendSharedPreferences("s23x", danagodzina23[1], Dieta.this);
                    sendSharedPreferences("s23y", danagodzina23[2], Dieta.this);
                    sendSharedPreferences("s23z", danagodzina23[3], Dieta.this);
                    sendSharedPreferences("s23zz", danagodzina23[4], Dieta.this);


                }
                if (zaznaczonyindex2 == 2) {

                    String[] danagodzina24 = ustalGodzinyPosilkow(DietaPozywienie.godzinyposilkow24);
                    sendSharedPreferences("s24a", danagodzina24[0], Dieta.this);
                    sendSharedPreferences("s24b", danagodzina24[1], Dieta.this);
                    sendSharedPreferences("s24c", danagodzina24[2], Dieta.this);
                    sendSharedPreferences("s24d", danagodzina24[3], Dieta.this);
                    sendSharedPreferences("s24e", danagodzina24[4], Dieta.this);

                    sendSharedPreferences("s24f", danagodzina24[0], Dieta.this);
                    sendSharedPreferences("s24g", danagodzina24[1], Dieta.this);
                    sendSharedPreferences("s24h", danagodzina24[2], Dieta.this);
                    sendSharedPreferences("s24i", danagodzina24[3], Dieta.this);
                    sendSharedPreferences("s24j", danagodzina24[4], Dieta.this);

                    sendSharedPreferences("s24k", danagodzina24[0], Dieta.this);
                    sendSharedPreferences("s24l", danagodzina24[1], Dieta.this);
                    sendSharedPreferences("s24m", danagodzina24[2], Dieta.this);
                    sendSharedPreferences("s24n", danagodzina24[3], Dieta.this);
                    sendSharedPreferences("s24o", danagodzina24[4], Dieta.this);

                    sendSharedPreferences("s24p", danagodzina24[0], Dieta.this);
                    sendSharedPreferences("s24r", danagodzina24[1], Dieta.this);
                    sendSharedPreferences("s24s", danagodzina24[2], Dieta.this);
                    sendSharedPreferences("s24t", danagodzina24[3], Dieta.this);
                    sendSharedPreferences("s24u", danagodzina24[4], Dieta.this);

                    sendSharedPreferences("s24w", danagodzina24[0], Dieta.this);
                    sendSharedPreferences("s24x", danagodzina24[1], Dieta.this);
                    sendSharedPreferences("s24y", danagodzina24[2], Dieta.this);
                    sendSharedPreferences("s24z", danagodzina24[3], Dieta.this);
                    sendSharedPreferences("s24zz", danagodzina24[4], Dieta.this);

                }


            }


        });


        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startFormularzD12();

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

    private void startFormularzD12() {

        AlertDialog.Builder dialog = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy jadasz posiłki regularnie ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz26(), 0, new DialogInterface.OnClickListener() {
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
                ProgressDialog();


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

    public static void sendSharedPreferences(String klucz, String wartosc, Context context) { // metoda ktora pakuje i wysyla wylosowane slowo do drugiej aktywnosci

        SharedPreferences preferencja = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = preferencja.edit();
        editor.putString(klucz, wartosc); // opakowujemy naszego stringa w metodzie putString gdzie identyfikujemy go w kolejnej aktywnosci za pomoca klucza
        editor.commit();


    }

    public static void setSharedPreferences(String klucz, Context context, TextView textView) { //ta metoda posluzy do odebrania i ustawienia odpowiedniego stringa wyslanego z poprzedniej aktywnosci
        SharedPreferences odpowiedz = PreferenceManager.getDefaultSharedPreferences(context);
        String daneodpowiedz = odpowiedz.getString(klucz, null);
        textView.setText(daneodpowiedz); // ustawienie odpowiedniego stringa w polu text view wygenerowanego raportu ...


    }


    public static String[] wylosujPosilekBezPowtorzen(String[] tab) {


        Random random = new Random(); // tworzymy obiekt typu random do wylosowania randomowego cwiczenia
        List<String> lista = new ArrayList<String>(Arrays.asList(tab)); // musimy utworzyc liste typu arraylist, a nastepnie przekonwertowac ja na
        // tablice jednowymiarowa, gdyz na takich tablicach cwiczen operujemy w osobnym
        // pliku, wszystko po to aby moc dynamicznie usuwac poszczegolne slowa
        // w danym kroku z listy tablicowej, gdyz w tablicach jednowymiarowyc
        // w tym przypadku by to nie zadzialalo
        int[] index = new int[1]; // tworzymy 3 elementowa pusta tablice typu int do przechowywania poszczegolnych indexow z tablic cwiczen
        String[] wylosowaneslowo = new String[1]; // tworzymy 3 elementowa tablice typu string ktora przechowuje poszczegolne wylosowane slowa
        for (int i = 0; i < index.length; i++) {

            index[i] = random.nextInt(lista.size());// w kazdym poszczegolnym indeksie tablicy przechowujemy pobrany indeks z tablicy cwiczen
            wylosowaneslowo[i] = lista.get(index[i]);// w kazdym poszczegolnym indeksie tablicy string, przechowujemy konkretne słowo wylosowane za
            lista.remove(index[i]);                    // pomoca obiektu random


        }

        lista.toArray(new String[0]); // na koncu znowu konwertujemy nasza liste na zwykla tablice


        return wylosowaneslowo; // zwracamy tablice wylosowanych slow


    }

    public String[] ustalGodzinyPosilkow(String[] tablica) { // w tym parametrze podajemy odpowiednia tablice z godzinami posilkow ...

        String[] godzina = new String[5]; // tablica do przechowywania godzin posilkow

        for (int i = 0; i < tablica.length; i++) {

            godzina[i] = tablica[i]; // na odpowiednim indeksie przechowywana jest poszczegolna godzina posilku
        }
        return godzina; // zwrocenie tablicy...

    }

    public void ProgressDialog() {

        final ProgressDialog progress = new ProgressDialog(Dieta.this);

        progress.setTitle("Proszę czekać...");
        progress.setMessage("Trwa generowanie raportu...");
        progress.show();


        Handler handler = new Handler(); // utworzenie handlera aby powiazac watek poboczny z głównym
        handler.postDelayed(new Runnable() { // do parametru metody postdelayed handlera przekazujemy obiekt runnable w ktorym startujemy nasz watek, aby to zrobic musimy zaimplementowac metode z interfejsu runnable w ktorej mowimy co ma sie stac./...
            @Override
            public void run() {
                progress.cancel();
                Intent intent = new Intent(Dieta.this,GotowaDieta.class);
                startActivity(intent);

            }
        }, 5000); // tutaj za pomoca metody postDelayed mowimy watkowi aby zostal wykonany po czasie 5sekund
    }





    }

















