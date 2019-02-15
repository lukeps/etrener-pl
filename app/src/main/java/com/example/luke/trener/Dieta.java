package com.example.luke.trener;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Dieta extends AppCompatActivity {

    private Button przycisk;
    private AlertDialog alertDialog;
    TabliceOdpowiedzi odpowiedz111 = new TabliceOdpowiedzi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dieta);


        przycisk = (Button)findViewById(R.id.button5);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startFormularzD();

            }
        });



    }


    private void startFormularzD(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Proszę podać płeć.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz1(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {
//                    String opcja1 = odpowiedz111.getOdpowiedz1()[1];


                    Toast.makeText(Dieta.this, ""+odpowiedz111.getOdpowiedz1().toString(), Toast.LENGTH_SHORT).show();

//
//                    String opcja1 = odpowiedz1.getOdpowiedz1()[1];
//                    Intent przeslijtext = new Intent(PlanTreningowy.this,Logowanie.class);
//                    przeslijtext.putExtra("opcja1",opcja1);


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
        alertDialog.show();



    }

    private void startFormularzD2(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Dlaczego potrzebujesz diety?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz18(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {


                }
                if (i == 1) {


                }
                if(i==2){

                }
                if(i==3){

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
        alertDialog.show();



    }

    private void startFormularzD3(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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
        alertDialog.show();



    }

    private void startFormularzD4(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile razy w tygodniu zamierzasz ćwiczyć?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz19(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {


                }
                if (i == 1) {


                }
                if (i==2) {

                }

                if (i==3){

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
        alertDialog.show();



    }
    private void startFormularzD5(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this);// builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Czy zamierzasz stosować w swojej diecie odżywki" + " " +  "oraz  suplementy diety?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
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
        alertDialog.show();



    }

    private void startFormularzD6(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Jeżeli uwzględniasz w swojej diecie suplementy, to jaką" + " " + " kwotę zamierzasz na nie przeznaczyć?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
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
        alertDialog.show();



    }

    private void startFormularzD7(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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
        alertDialog.show();



    }

    private void startFormularzD8(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Ile zamierzasz wydać na produkty spożywcze w ciągu" +" " +"miesiąca?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
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
        alertDialog.show();



    }

    private void startFormularzD9(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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
        alertDialog.show();



    }

    private void startFormularzD10(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(Dieta.this);
        textView.setText("Ile czasu jesteś w stanie poświęcić na przygotowanie" + " " + "posiłków?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
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
                if(i == 2)  {

                }

                if(i == 3)  {


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
        alertDialog.show();



    }

    private void startFormularzD11(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("O której przeważnie kładziesz się spać?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz25(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (i == 0) {


                }
                if (i == 1) {


                }
                if(i == 2)  {

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
        alertDialog.show();



    }

    private void startFormularzD12(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(Dieta.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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

                Intent intent = new Intent(Dieta.this,GotowaDieta.class);
                startActivity(intent);

            }
        });



        dialog.setNegativeButton("Przerwij", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                alertDialog.dismiss();

            }
        });

        alertDialog = dialog.create();
        alertDialog.show();



    }














}
