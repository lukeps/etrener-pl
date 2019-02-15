package com.example.luke.trener;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
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
            przycisk111 = (Button) findViewById(R.id.przycisk12);

        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build()); // zapewnia dostęp do zapisu plików np w galerii w wersjach =>24 SDK androida w innym wypadku wyrzuci wyjątek o braku mozliwosci dosdtepuy

        if (ContextCompat.checkSelfPermission(this, // warunki zapewniające dostęp do praw zapisu i odczytu plików w SDK od 24 androida trzeba ustalic programowo w kodzie, w manifescie działa lecz w wersjach nizszych niz 24
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_READ_CONTACTS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
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
                print();
                Toast.makeText(GotowyPlanTreningowy.this,"Plan został zapisany!",Toast.LENGTH_LONG).show();




                }
            });

            ustalCwiczenieNogi();


        }


        public void ustalCwiczenieNogi () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp1 = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane = cwiczenieodp1.getString("id", "");
                odczytanieopcji.setText(dane);

                SharedPreferences cwiczenieodp1a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane1 = cwiczenieodp1a.getString("id1a", "");
                odczytanieopcji2.setText(dane1);

                wyswietlPlan();

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp1b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2 = cwiczenieodp1b.getString("id1b", "");
                odczytanieopcji.setText(dane2);

                SharedPreferences cwiczenieodp1c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3 = cwiczenieodp1c.getString("id1c", "");
                odczytanieopcji2.setText(dane3);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp1d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4 = cwiczenieodp1d.getString("id1d", "");
                odczytanieopcji.setText(dane4);

                SharedPreferences cwiczenieodp1e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5 = cwiczenieodp1e.getString("id1e", "");
                odczytanieopcji2.setText(dane5);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp1f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6 = cwiczenieodp1f.getString("id1f", "");
                odczytanieopcji.setText(dane6);

                SharedPreferences cwiczenieodp1g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7 = cwiczenieodp1g.getString("id1g", "");
                odczytanieopcji2.setText(dane7);

                SharedPreferences cwiczenieodp1h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane8 = cwiczenieodp1h.getString("id1h", "");
                odczytanieopcji3.setText(dane8);

                wyswietlPlan();


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp1i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane9 = cwiczenieodp1i.getString("id1i", "");
                odczytanieopcji.setText(dane9);

                SharedPreferences cwiczenieodp1j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane10 = cwiczenieodp1j.getString("id1j", "");
                odczytanieopcji2.setText(dane10);

                SharedPreferences cwiczenieodp1k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane11 = cwiczenieodp1k.getString("id1k", "");
                odczytanieopcji3.setText(dane11);

                wyswietlPlan();


            } else {

                SharedPreferences cwiczenieodp1l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane12 = cwiczenieodp1l.getString("id1l", "");
                odczytanieopcji.setText(dane12);

                SharedPreferences cwiczenieodp1m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane13 = cwiczenieodp1m.getString("id1m", "");
                odczytanieopcji2.setText(dane13);

                SharedPreferences cwiczenieodp1n = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane14 = cwiczenieodp1n.getString("id1n", "");
                odczytanieopcji3.setText(dane14);

                wyswietlPlan();

            }


        }

        public void ustalCwiczenieKlatkaPiersiowa () {

            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp2a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2a = cwiczenieodp2a.getString("id2a", "");
                odczytanieopcji4.setText(dane2a);

                SharedPreferences cwiczenieodp2b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2b = cwiczenieodp2b.getString("id2b", "");
                odczytanieopcji5.setText(dane2b);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp2c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2c = cwiczenieodp2c.getString("id2c", "");
                odczytanieopcji4.setText(dane2c);

                SharedPreferences cwiczenieodp2d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2d = cwiczenieodp2d.getString("id2d", "");
                odczytanieopcji5.setText(dane2d);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp2e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2e = cwiczenieodp2e.getString("id2e", "");
                odczytanieopcji4.setText(dane2e);

                SharedPreferences cwiczenieodp2f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2f = cwiczenieodp2f.getString("id2f", "");
                odczytanieopcji5.setText(dane2f);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp2g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2g = cwiczenieodp2g.getString("id2g", "");
                odczytanieopcji4.setText(dane2g);

                SharedPreferences cwiczenieodp2h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2h = cwiczenieodp2h.getString("id2h", "");
                odczytanieopcji5.setText(dane2h);

                SharedPreferences cwiczenieodp2i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2i = cwiczenieodp2i.getString("id2i", "");
                odczytanieopcji6.setText(dane2i);

                SharedPreferences cwiczenieodp2j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2j = cwiczenieodp2j.getString("id2j", "");
                odczytanieopcji7.setText(dane2j);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp2k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2k = cwiczenieodp2k.getString("id2k", "");
                odczytanieopcji4.setText(dane2k);

                SharedPreferences cwiczenieodp2l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2l = cwiczenieodp2l.getString("id2l", "");
                odczytanieopcji5.setText(dane2l);

                SharedPreferences cwiczenieodp2m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2m = cwiczenieodp2m.getString("id2m", "");
                odczytanieopcji6.setText(dane2m);

            } else {

                SharedPreferences cwiczenieodp2n = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2n = cwiczenieodp2n.getString("id2n", "");
                odczytanieopcji4.setText(dane2n);

                SharedPreferences cwiczenieodp2o = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2o = cwiczenieodp2o.getString("id2o", "");
                odczytanieopcji5.setText(dane2o);

                SharedPreferences cwiczenieodp2p = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2p = cwiczenieodp2p.getString("id2p", "");
                odczytanieopcji6.setText(dane2p);

                SharedPreferences cwiczenieodp2r = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane2r = cwiczenieodp2r.getString("id2r", "");
                odczytanieopcji7.setText(dane2r);

            }


        }

        public void ustalCwiczenieBrzuch () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp3a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3a = cwiczenieodp3a.getString("id3a", "");
                odczytanieopcji8.setText(dane3a);

                SharedPreferences cwiczenieodp3b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3b = cwiczenieodp3b.getString("id3b", "");
                odczytanieopcji9.setText(dane3b);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp3c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3c = cwiczenieodp3c.getString("id3c", "");
                odczytanieopcji8.setText(dane3c);

                SharedPreferences cwiczenieodp3d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3d = cwiczenieodp3d.getString("id3d", "");
                odczytanieopcji9.setText(dane3d);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp3e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3e = cwiczenieodp3e.getString("id3e", "");
                odczytanieopcji8.setText(dane3e);

                SharedPreferences cwiczenieodp3f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3f = cwiczenieodp3f.getString("id3f", "");
                odczytanieopcji9.setText(dane3f);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp3g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3g = cwiczenieodp3g.getString("id3g", "");
                odczytanieopcji8.setText(dane3g);

                SharedPreferences cwiczenieodp3h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3h = cwiczenieodp3h.getString("id3h", "");
                odczytanieopcji9.setText(dane3h);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp3i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3i = cwiczenieodp3i.getString("id3i", "");
                odczytanieopcji8.setText(dane3i);

                SharedPreferences cwiczenieodp3j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3j = cwiczenieodp3j.getString("id3j", "");
                odczytanieopcji9.setText(dane3j);


            } else {

                SharedPreferences cwiczenieodp3k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3k = cwiczenieodp3k.getString("id3k", "");
                odczytanieopcji8.setText(dane3k);

                SharedPreferences cwiczenieodp3l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3l = cwiczenieodp3l.getString("id3l", "");
                odczytanieopcji9.setText(dane3l);

                SharedPreferences cwiczenieodp3m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane3m = cwiczenieodp3m.getString("id3m", "");
                odczytanieopcji10.setText(dane3m);

            }

        }


        public void ustalCwiczenieBarki () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp4a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4a = cwiczenieodp4a.getString("id4a", "");
                odczytanieopcji11.setText(dane4a);

                SharedPreferences cwiczenieodp4b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4b = cwiczenieodp4b.getString("id4b", "");
                odczytanieopcji12.setText(dane4b);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp4c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4c = cwiczenieodp4c.getString("id4c", "");
                odczytanieopcji11.setText(dane4c);

                SharedPreferences cwiczenieodp4d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4d = cwiczenieodp4d.getString("id4d", "");
                odczytanieopcji12.setText(dane4d);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp4e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4e = cwiczenieodp4e.getString("id4e", "");
                odczytanieopcji11.setText(dane4e);

                SharedPreferences cwiczenieodp4f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4f = cwiczenieodp4f.getString("id4f", "");
                odczytanieopcji12.setText(dane4f);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp4g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4g = cwiczenieodp4g.getString("id4g", "");
                odczytanieopcji11.setText(dane4g);

                SharedPreferences cwiczenieodp4h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4h = cwiczenieodp4h.getString("id4h", "");
                odczytanieopcji12.setText(dane4h);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp4i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4i = cwiczenieodp4i.getString("id4i", "");
                odczytanieopcji11.setText(dane4i);

                SharedPreferences cwiczenieodp4j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4j = cwiczenieodp4j.getString("id4j", "");
                odczytanieopcji12.setText(dane4j);


            } else {

                SharedPreferences cwiczenieodp4k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4k = cwiczenieodp4k.getString("id4k", "");
                odczytanieopcji11.setText(dane4k);

                SharedPreferences cwiczenieodp4l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4l = cwiczenieodp4l.getString("id4l", "");
                odczytanieopcji12.setText(dane4l);

                SharedPreferences cwiczenieodp4m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane4m = cwiczenieodp4m.getString("id4m", "");
                odczytanieopcji13.setText(dane4m);

            }

        }


        public void ustalCwiczenieTriceps () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp5a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5a = cwiczenieodp5a.getString("id5a", "");
                odczytanieopcji14.setText(dane5a);

                SharedPreferences cwiczenieodp5b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5b = cwiczenieodp5b.getString("id5b", "");
                odczytanieopcji15.setText(dane5b);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp5c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5c = cwiczenieodp5c.getString("id5c", "");
                odczytanieopcji14.setText(dane5c);

                SharedPreferences cwiczenieodp5d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5d = cwiczenieodp5d.getString("id5d", "");
                odczytanieopcji15.setText(dane5d);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp5e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5e = cwiczenieodp5e.getString("id5e", "");
                odczytanieopcji14.setText(dane5e);

                SharedPreferences cwiczenieodp5f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5f = cwiczenieodp5f.getString("id5f", "");
                odczytanieopcji15.setText(dane5f);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp5g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5g = cwiczenieodp5g.getString("id5g", "");
                odczytanieopcji14.setText(dane5g);

                SharedPreferences cwiczenieodp5h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5h = cwiczenieodp5h.getString("id5h", "");
                odczytanieopcji15.setText(dane5h);

                SharedPreferences cwiczenieodp5i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5i = cwiczenieodp5i.getString("id5i", "");
                odczytanieopcji16.setText(dane5i);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp5j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5j = cwiczenieodp5j.getString("id5j", "");
                odczytanieopcji14.setText(dane5j);

                SharedPreferences cwiczenieodp5k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5k = cwiczenieodp5k.getString("id5k", "");
                odczytanieopcji15.setText(dane5k);

                SharedPreferences cwiczenieodp5l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5l = cwiczenieodp5l.getString("id5l", "");
                odczytanieopcji16.setText(dane5l);

            } else {

                SharedPreferences cwiczenieodp5m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5m = cwiczenieodp5m.getString("id5m", "");
                odczytanieopcji14.setText(dane5m);

                SharedPreferences cwiczenieodp5n = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5n = cwiczenieodp5n.getString("id5n", "");
                odczytanieopcji15.setText(dane5n);

                SharedPreferences cwiczenieodp5o = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane5o = cwiczenieodp5o.getString("id5o", "");
                odczytanieopcji16.setText(dane5o);
            }


        }


        public void ustalCwiczeniePlecy () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp6a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6a = cwiczenieodp6a.getString("id6a", "");
                odczytanieopcji17.setText(dane6a);

                SharedPreferences cwiczenieodp6b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6b = cwiczenieodp6b.getString("id6b", "");
                odczytanieopcji18.setText(dane6b);

                SharedPreferences cwiczenieodp6c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6c = cwiczenieodp6c.getString("id6c", "");
                odczytanieopcji19.setText(dane6c);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp6d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6d = cwiczenieodp6d.getString("id6d", "");
                odczytanieopcji17.setText(dane6d);

                SharedPreferences cwiczenieodp6e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6e = cwiczenieodp6e.getString("id6e", "");
                odczytanieopcji18.setText(dane6e);

                SharedPreferences cwiczenieodp6f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6f = cwiczenieodp6f.getString("id6f", "");
                odczytanieopcji19.setText(dane6f);


            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp6g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6g = cwiczenieodp6g.getString("id6g", "");
                odczytanieopcji17.setText(dane6g);

                SharedPreferences cwiczenieodp6h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6h = cwiczenieodp6h.getString("id6h", "");
                odczytanieopcji18.setText(dane6h);

                SharedPreferences cwiczenieodp6i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6i = cwiczenieodp6i.getString("id6i", "");
                odczytanieopcji19.setText(dane6i);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp6j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6j = cwiczenieodp6j.getString("id6j", "");
                odczytanieopcji17.setText(dane6j);

                SharedPreferences cwiczenieodp6k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6k = cwiczenieodp6k.getString("id6k", "");
                odczytanieopcji18.setText(dane6k);

                SharedPreferences cwiczenieodp6l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6l = cwiczenieodp6l.getString("id6l", "");
                odczytanieopcji19.setText(dane6l);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp6m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6m = cwiczenieodp6m.getString("id6m", "");
                odczytanieopcji17.setText(dane6m);

                SharedPreferences cwiczenieodp6n = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6n = cwiczenieodp6n.getString("id6n", "");
                odczytanieopcji18.setText(dane6n);

                SharedPreferences cwiczenieodp6o = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6o = cwiczenieodp6o.getString("id6o", "");
                odczytanieopcji19.setText(dane6o);

            } else {

                SharedPreferences cwiczenieodp6p = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6p = cwiczenieodp6p.getString("id6p", "");
                odczytanieopcji17.setText(dane6p);

                SharedPreferences cwiczenieodp6r = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6r = cwiczenieodp6r.getString("id6r", "");
                odczytanieopcji18.setText(dane6r);

                SharedPreferences cwiczenieodp6s = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6s = cwiczenieodp6s.getString("id6s", "");
                odczytanieopcji19.setText(dane6s);

                SharedPreferences cwiczenieodp6t = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane6t = cwiczenieodp6t.getString("id6t", "");
                odczytanieopcji20.setText(dane6t);
            }


        }


        public void ustalCwiczenieBiceps () {


            if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp7a = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7a = cwiczenieodp7a.getString("id7a", "");
                odczytanieopcji21.setText(dane7a);

                SharedPreferences cwiczenieodp7b = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7b = cwiczenieodp7b.getString("id7b", "");
                odczytanieopcji22.setText(dane7b);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp7c = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7c = cwiczenieodp7c.getString("id7c", "");
                odczytanieopcji21.setText(dane7c);

                SharedPreferences cwiczenieodp7d = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7d = cwiczenieodp7d.getString("id7d", "");
                odczytanieopcji22.setText(dane7d);

            } else if (PlanTreningowy.selected1 == 0 || PlanTreningowy.selected1 == 1 && PlanTreningowy.selected2 == 2) {

                SharedPreferences cwiczenieodp7e = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7e = cwiczenieodp7e.getString("id7e", "");
                odczytanieopcji21.setText(dane7e);

                SharedPreferences cwiczenieodp7f = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7f = cwiczenieodp7f.getString("id7f", "");
                odczytanieopcji22.setText(dane7f);

            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 0) {

                SharedPreferences cwiczenieodp7g = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7g = cwiczenieodp7g.getString("id7g", "");
                odczytanieopcji21.setText(dane7g);

                SharedPreferences cwiczenieodp7h = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7h = cwiczenieodp7h.getString("id7h", "");
                odczytanieopcji22.setText(dane7h);

                SharedPreferences cwiczenieodp7i = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7i = cwiczenieodp7i.getString("id7i", "");
                odczytanieopcji23.setText(dane7i);


            } else if (PlanTreningowy.selected1 == 2 && PlanTreningowy.selected2 == 1) {

                SharedPreferences cwiczenieodp7j = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7j = cwiczenieodp7j.getString("id7j", "");
                odczytanieopcji21.setText(dane7j);

                SharedPreferences cwiczenieodp7k = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7k = cwiczenieodp7k.getString("id7k", "");
                odczytanieopcji22.setText(dane7k);

                SharedPreferences cwiczenieodp7l = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7l = cwiczenieodp7l.getString("id7l", "");
                odczytanieopcji23.setText(dane7l);


            } else {

                SharedPreferences cwiczenieodp7m = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7m = cwiczenieodp7m.getString("id7m", "");
                odczytanieopcji21.setText(dane7m);

                SharedPreferences cwiczenieodp7n = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7n = cwiczenieodp7n.getString("id7n", "");
                odczytanieopcji22.setText(dane7n);

                SharedPreferences cwiczenieodp7o = PreferenceManager.getDefaultSharedPreferences(GotowyPlanTreningowy.this);
                String dane7o = cwiczenieodp7o.getString("id7o", "");
                odczytanieopcji23.setText(dane7o);

            }

        }

//    private void screenshot(){
//
//        String filename = Environment.getExternalStorageDirectory() + "/kurwa/" + ".jpg";
//        View root = getWindow().getDecorView();
//        root.setDrawingCacheEnabled(true);
//        Bitmap bitmap = Bitmap.createBitmap(root.getDrawingCache());
//        root.setDrawingCacheEnabled(false);
//
//        File file = new File(filename);
//        file.getParentFile().mkdirs();
//
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
//            fos.flush();
//            fos.close();
//
//            Uri uri =Uri.fromFile(file);
//            Intent intencja = new Intent(Intent.ACTION_VIEW);
//            intencja.setDataAndType(uri,"image/*");
//            startActivity(intencja);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//    }


    private void print(){ //metoda drukujaca bitmape do jpg


        Bitmap bitmap = getBitmapFromView(scrollview,scrollview.getChildAt(0).getHeight(),scrollview.getChildAt(0).getWidth());
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
    private Bitmap getBitmapFromView(View view,int height,int width) { // metoda która tworzy obraz z widoku w tym wypadku ze scrollview naszego xmla
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
}









