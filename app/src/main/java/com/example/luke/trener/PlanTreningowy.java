package com.example.luke.trener;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

        przycisk = (Button)findViewById(R.id.button3);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startFormularz();

            }
        });




    }



    public void startFormularz(){

         AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
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
        alertDialog.show();



    }

    public void startFormularz2(){

        final  AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twoja aktywność fizyczna.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz2(), -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                  selected1 = i;



                if(selected1==0 || selected1==1 && selected2==0) { //jezeli umiarkowana lub intensywna aktywnosc i trening z wolnymi to


                    ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////

                    String opcja1 = TabliceCwiczen.zestaw1[0];


                    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("id", opcja1); //InputString: from the EditText
                    editor.commit();

                    String opcjaa1 = TabliceCwiczen.zestaw1[5];


                    SharedPreferences prefss1 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr1 = prefss1.edit();
                    editorr1.putString("id1a", opcjaa1); //InputString: from the EditText
                    editorr1.commit();

                    /////////////////////KLATKA PIERSIOWA////////////////////////////////


                    String opcja2a = TabliceCwiczen.zestaw1[4];



                    SharedPreferences prefs2a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2a = prefs2a.edit();
                    editorr2a.putString("id2a", opcja2a); //InputString: from the EditText
                    editorr2a.commit();

                    String opcja2b = TabliceCwiczen.zestaw2[6];


                    SharedPreferences prefs2b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2b = prefs2b.edit();
                    editorr2b.putString("id2b", opcja2b); //InputString: from the EditText
                    editorr2b.commit();

                    /////////////////////BRZUCH////////////////////////////////


                    String opcja3a = TabliceCwiczen.zestaw3[4];



                    SharedPreferences prefs3a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3a = prefs3a.edit();
                    editorr3a.putString("id3a", opcja3a); //InputString: from the EditText
                    editorr3a.commit();

                    String opcja3b = TabliceCwiczen.zestaw3[8];


                    SharedPreferences prefs3b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3b = prefs3b.edit();
                    editorr3b.putString("id3b", opcja3b); //InputString: from the EditText
                    editorr3b.commit();

                    /////////////////////BARKI////////////////////////////////


                    String opcja4a = TabliceCwiczen.zestaw4[0];



                    SharedPreferences prefs4a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4a = prefs4a.edit();
                    editorr4a.putString("id4a", opcja4a); //InputString: from the EditText
                    editorr4a.commit();

                    String opcja4b = TabliceCwiczen.zestaw4[3];


                    SharedPreferences prefs4b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4b = prefs4b.edit();
                    editorr4b.putString("id4b", opcja4b); //InputString: from the EditText
                    editorr4b.commit();

                    /////////////////////TRICEPS////////////////////////////////

                    Random random = new Random(); // utworz nowy obiekt typu Random do losowania randomowych wartosci z okreslonej tablicy
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepswolne)); // Konwersja zwyklej tablicy na liste typu string koniecznej do usuwania juz wylosowanego elementu



                    if(lista.size()>0) {  // jezeli rozmiar listy jest wiekszy niz zero
                        int getrandomindex = random.nextInt(lista.size()); // to utworz zmienna typu int ktora bedzie przechowywac indeks z listy wylosowanego elementu ( czyli słowo na danej pozycji) musi losowac z zakresu wiekszego niż Zero gdyz inaczej wyrzuci wyjatek z metody NextInt

                        String opcja5a = lista.get(getrandomindex); // w zmiennej String przechowujemy pobrany element z listy ( numer indeksu  wskazujacy na danej słowo)
                        lista.remove(getrandomindex); // nastepnie usuwamy te wylosowane słowo dzieki czemu rozmiar listy sie zmniejsza


                        TabliceCwiczen.zestawtricepswolne = lista.toArray(new String[0]); // konwertujemy liste spowrotem na tablice jednowymiarową tak jak było na początku

                        SharedPreferences prefs5a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5a = prefs5a.edit();
                        editorr5a.putString("id5a", opcja5a); // do zmiennej editorr5a "wsadzamy"  indeks oraz wylosowane słowo z tablicy które przechowywane jest w zmiennej opcja5a, a następnie wysyłamy te spakowanej dane w inne miejsce aplikacji które odebrać można za pomocą pierwszego argumentu jakim jest ID czyli id5a
                        editorr5a.commit();

                    }

                    if (lista.size()>0) {
                        int getrandomindex2 = random.nextInt(lista.size()); // to samo co powyzej, tylko losowanie nastepuje z listy pomniejszonej o jeden przez co nie ma mozliwosci duplikatu wylosowanej wartosci

                        String opcja5b = lista.get(getrandomindex2);

                        lista.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepswolne = lista.toArray(new String[0]);

                        SharedPreferences prefs5b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5b = prefs5b.edit();
                        editorr5b.putString("id5b", opcja5b); //InputString: from the EditText
                        editorr5b.commit();
                    }


                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecywolne));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6a = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecywolne = lista.toArray(new String[0]);

                        SharedPreferences prefs6a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6a = prefs6a.edit();
                        editorr6a.putString("id6a", opcja6a); //InputString: from the EditText
                        editorr6a.commit();

                    }

                    if (listaplecy.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy.size());

                        String opcja6b = listaplecy.get(getrandomindexp2);

                        listaplecy.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6b = prefs6b.edit();
                        editorr6b.putString("id6b", opcja6b); //InputString: from the EditText
                        editorr6b.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6c = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6c = prefs6c.edit();
                        editorr6c.putString("id6c", opcja6c); //InputString: from the EditText
                        editorr6c.commit();
                    }


                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepswolne));



                    if(listabiceps.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps.size());

                        String opcja7a = listabiceps.get(getrandomindexb1);
                        listabiceps.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7a = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7a = prefs7a.edit();
                        editorr7a.putString("id7a", opcja7a); //InputString: from the EditText
                        editorr7a.commit();

                    }


                    if(listabiceps.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps.size());

                        String opcja7b = listabiceps.get(getrandomindexb2);
                        listabiceps.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7b = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7b = prefs7b.edit();
                        editorr7b.putString("id7b", opcja7b); //InputString: from the EditText
                        editorr7b.commit();

                    }















                }


                    else if(selected1==0 || selected1==1 && selected2==1){  //jezeli umiarkowana lub intensywna aktywnosc i trening z maszynami to

                        String opcjaa2 = TabliceCwiczen.zestaw1[1];


                        ///////////NOGI/////////////////////////////////////////////////////////////////////////////////////////



                        SharedPreferences prefss2 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr2 = prefss2.edit();
                        editorr2.putString("id1b", opcjaa2); //InputString: from the EditText
                        editorr2.commit();

                        String opcjaa3 = TabliceCwiczen.zestaw2[1];


                        SharedPreferences prefss3 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr3 = prefss3.edit();
                        editorr3.putString("id1c", opcjaa3); //InputString: from the EditText
                        editorr3.commit();


                        ///////////KLATKA PIERSIOWA/////////////////////////////

                        String opcja2c = TabliceCwiczen.zestaw2[7];



                        SharedPreferences prefs2c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr2c = prefs2c.edit();
                        editorr2c.putString("id2c", opcja2c); //InputString: from the EditText
                        editorr2c.commit();

                        String opcja2d = TabliceCwiczen.zestaw2[8];


                        SharedPreferences prefs2d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr2d = prefs2d.edit();
                        editorr2d.putString("id2d", opcja2d); //InputString: from the EditText
                        editorr2d.commit();

                        /////////////////////BRZUCH////////////////////////////////


                        String opcja3c = TabliceCwiczen.zestaw3[6];



                        SharedPreferences prefs3c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr3c = prefs3c.edit();
                        editorr3c.putString("id3c", opcja3c); //InputString: from the EditText
                        editorr3c.commit();

                        String opcja3d = TabliceCwiczen.zestaw3[7];


                        SharedPreferences prefs3d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr3d = prefs3d.edit();
                        editorr3d.putString("id3d", opcja3d); //InputString: from the EditText
                        editorr3d.commit();

                        /////////////////////BARKI////////////////////////////////


                        String opcja4c = TabliceCwiczen.zestaw4[10];



                        SharedPreferences prefs4c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr4c = prefs4c.edit();
                        editorr4c.putString("id4c", opcja4c); //InputString: from the EditText
                        editorr4c.commit();

                        String opcja4d = TabliceCwiczen.zestaw4[9];


                        SharedPreferences prefs4d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr4d = prefs4d.edit();
                        editorr4d.putString("id4d", opcja4d); //InputString: from the EditText
                        editorr4d.commit();

                    /////////////////////TRICEPS////////////////////////////////

                    Random random = new Random();
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepsmaszyny));



                    if(lista.size()>0) {
                        int getrandomindex = random.nextInt(lista.size());

                        String opcja5c = lista.get(getrandomindex);
                        lista.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5c = prefs5c.edit();
                        editorr5c.putString("id5c", opcja5c); //InputString: from the EditText
                        editorr5c.commit();

                    }

                    if (lista.size()>0) {
                        int getrandomindex2 = random.nextInt(lista.size());

                        String opcja5d = lista.get(getrandomindex2);

                        lista.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5d = prefs5d.edit();
                        editorr5d.putString("id5d", opcja5d); //InputString: from the EditText
                        editorr5d.commit();
                    }


                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecymaszyny));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6d = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecymaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs6d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6d = prefs6d.edit();
                        editorr6d.putString("id6d", opcja6d); //InputString: from the EditText
                        editorr6d.commit();

                    }

                    if (listaplecy.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy.size());

                        String opcja6e = listaplecy.get(getrandomindexp2);

                        listaplecy.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6e = prefs6e.edit();
                        editorr6e.putString("id6e", opcja6e); //InputString: from the EditText
                        editorr6e.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6f = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6f = prefs6f.edit();
                        editorr6f.putString("id6f", opcja6f); //InputString: from the EditText
                        editorr6f.commit();
                    }


                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepsmaszyny));



                    if(listabiceps.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps.size());

                        String opcja7c = listabiceps.get(getrandomindexb1);
                        listabiceps.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7c = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7c = prefs7c.edit();
                        editorr7c.putString("id7c", opcja7c); //InputString: from the EditText
                        editorr7c.commit();

                    }


                    if(listabiceps.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps.size());

                        String opcja7d = listabiceps.get(getrandomindexb2);
                        listabiceps.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7d = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7d = prefs7d.edit();
                        editorr7d.putString("id7d", opcja7d); //InputString: from the EditText
                        editorr7d.commit();

                    }











                }

                else if(selected1==0 || selected1==1 && selected2==2){ //jezeli umiarkowana lub intensywna aktywnosc i trening zroznicowany

                        /////////NOGI//////////////////////////////////////////

                    String opcjaa4 = TabliceCwiczen.zestaw1[0];


                    SharedPreferences prefss4 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4 = prefss4.edit();
                    editorr4.putString("id1d", opcjaa4); //InputString: from the EditText
                    editorr4.commit();

                    String opcjaa5 = TabliceCwiczen.zestaw1[1];


                    SharedPreferences prefss5 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr5 = prefss5.edit();
                    editorr5.putString("id1e", opcjaa5); //InputString: from the EditText
                    editorr5.commit();

                    ///////////KLATKA PIERSIOWA/////////////////////////////

                    String opcja2e = TabliceCwiczen.zestaw2[7];



                    SharedPreferences prefs2e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2e = prefs2e.edit();
                    editorr2e.putString("id2e", opcja2e); //InputString: from the EditText
                    editorr2e.commit();

                    String opcja2f = TabliceCwiczen.zestaw2[9];


                    SharedPreferences prefs2f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2f = prefs2f.edit();
                    editorr2f.putString("id2f", opcja2f); //InputString: from the EditText
                    editorr2f.commit();

                    //////////////////BRZUCH/////////////////////////////////////////////////

                    String opcja3e = TabliceCwiczen.zestaw3[1];



                    SharedPreferences prefs3e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3e = prefs3e.edit();
                    editorr3e.putString("id3e", opcja3e); //InputString: from the EditText
                    editorr3e.commit();

                    String opcja3f = TabliceCwiczen.zestaw3[7];


                    SharedPreferences prefs3f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3f = prefs3f.edit();
                    editorr3f.putString("id3f", opcja3f); //InputString: from the EditText
                    editorr3f.commit();

                    /////////////////////BARKI////////////////////////////////


                    String opcja4e = TabliceCwiczen.zestaw4[1];



                    SharedPreferences prefs4e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4e = prefs4e.edit();
                    editorr4e.putString("id4e", opcja4e); //InputString: from the EditText
                    editorr4e.commit();

                    String opcja4f = TabliceCwiczen.zestaw4[8];


                    SharedPreferences prefs4f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4f = prefs4f.edit();
                    editorr4f.putString("id4f", opcja4f); //InputString: from the EditText
                    editorr4f.commit();


                    /////////////////////TRICEPS////////////////////////////////

                    Random random = new Random();
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepsmaszyny));
                    List<String> lista2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepswolne));


                    if(lista.size()>0) {
                        int getrandomindex = random.nextInt(lista.size());

                        String opcja5e = lista.get(getrandomindex);
                        lista.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5e = prefs5e.edit();
                        editorr5e.putString("id5e", opcja5e); //InputString: from the EditText
                        editorr5e.commit();

                    }

                    if (lista2.size()>0) {
                        int getrandomindex2 = random.nextInt(lista2.size());

                        String opcja5f = lista2.get(getrandomindex2);

                        lista2.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepswolne = lista2.toArray(new String[0]);

                        SharedPreferences prefs5f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5f = prefs5f.edit();
                        editorr5f.putString("id5f", opcja5f); //InputString: from the EditText
                        editorr5f.commit();
                    }

                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecywolne));
                    List<String> listaplecy2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecymaszyny));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6g = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecywolne = lista.toArray(new String[0]);

                        SharedPreferences prefs6g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6g = prefs6g.edit();
                        editorr6g.putString("id6g", opcja6g); //InputString: from the EditText
                        editorr6g.commit();

                    }

                    if (listaplecy2.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy2.size());

                        String opcja6h = listaplecy2.get(getrandomindexp2);

                        listaplecy2.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy2.toArray(new String[0]);

                        SharedPreferences prefs6h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6h = prefs6h.edit();
                        editorr6h.putString("id6h", opcja6h); //InputString: from the EditText
                        editorr6h.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6i = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6i = prefs6i.edit();
                        editorr6i.putString("id6i", opcja6i); //InputString: from the EditText
                        editorr6i.commit();
                    }


                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepsmaszyny));
                    List<String> listabiceps2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepswolne));




                    if(listabiceps.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps.size());

                        String opcja7e = listabiceps.get(getrandomindexb1);
                        listabiceps.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7e = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7e = prefs7e.edit();
                        editorr7e.putString("id7e", opcja7e); //InputString: from the EditText
                        editorr7e.commit();

                    }


                    if(listabiceps2.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps2.size());

                        String opcja7f = listabiceps2.get(getrandomindexb2);
                        listabiceps2.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepswolne = listabiceps2.toArray(new String[0]);

                        SharedPreferences prefs7f = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7f = prefs7f.edit();
                        editorr7f.putString("id7f", opcja7f); //InputString: from the EditText
                        editorr7f.commit();

                    }










                }

                else if( selected1==2 && selected2==0){ // jezeli bardzo wysoka intensywnosc i wolne ciezary to



                        ////////////nOGI//////////////////////////
                    String opcjaa6 = TabliceCwiczen.zestaw1[5];


                    SharedPreferences prefss6 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr6 = prefss6.edit();
                    editorr6.putString("id1f", opcjaa6); //InputString: from the EditText
                    editorr6.commit();

                    String opcjaa7 = TabliceCwiczen.zestaw1[7];


                    SharedPreferences prefss7 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr7 = prefss7.edit();
                    editorr7.putString("id1g", opcjaa7); //InputString: from the EditText
                    editorr7.commit();

                    String opcjaa8 = TabliceCwiczen.zestaw1[8];


                    SharedPreferences prefss8 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr8 = prefss8.edit();
                    editorr8.putString("id1h", opcjaa8); //InputString: from the EditText
                    editorr8.commit();


                    ///////////KLATKA PIERSIOWA/////////////////////////////

                    String opcja2g = TabliceCwiczen.zestaw1[4];



                    SharedPreferences prefs2g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2g = prefs2g.edit();
                    editorr2g.putString("id2g", opcja2g); //InputString: from the EditText
                    editorr2g.commit();

                    String opcja2h = TabliceCwiczen.zestaw1[6];


                    SharedPreferences prefs2h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2h = prefs2h.edit();
                    editorr2h.putString("id2h", opcja2h); //InputString: from the EditText
                    editorr2h.commit();

                    String opcja2i = TabliceCwiczen.zestaw2[8];


                    SharedPreferences prefs2i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2i = prefs2i.edit();
                    editorr2i.putString("id2i", opcja2i); //InputString: from the EditText
                    editorr2i.commit();

                    String opcja2j = TabliceCwiczen.zestaw2[3];


                    SharedPreferences prefs2j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2j = prefs2j.edit();
                    editorr2j.putString("id2j", opcja2j); //InputString: from the EditText
                    editorr2j.commit();

                    //////////////////BRZUCH/////////////////////////////////////////////////

                    String opcja3g = TabliceCwiczen.zestaw3[2];



                    SharedPreferences prefs3g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3g = prefs3g.edit();
                    editorr3g.putString("id3g", opcja3g); //InputString: from the EditText
                    editorr3g.commit();

                    String opcja3h = TabliceCwiczen.zestaw3[0];


                    SharedPreferences prefs3h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3h = prefs3h.edit();
                    editorr3h.putString("id3h", opcja3h); //InputString: from the EditText
                    editorr3h.commit();

                    /////////////////////BARKI////////////////////////////////


                    String opcja4g = TabliceCwiczen.zestaw4[4];



                    SharedPreferences prefs4g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4g = prefs4g.edit();
                    editorr4g.putString("id4g", opcja4g); //InputString: from the EditText
                    editorr4g.commit();

                    String opcja4h = TabliceCwiczen.zestaw4[2];

//                    Random random = new Random();
//                    int getrandomindex = random.nextInt(TabliceCwiczen.zestaw4.length);
//                    String wylosujcwiczenie = (TabliceCwiczen.zestaw4[getrandomindex]);


                    SharedPreferences prefs4h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4h = prefs4h.edit();
                    editorr4h.putString("id4h", opcja4h); //InputString: from the EditText
                    editorr4h.commit();

                    /////////////////////TRICEPS////////////////////////////////

                                       Random random = new Random();
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepswolne));

                    if(lista.size()>0) {
                        int getrandomindex = random.nextInt(lista.size());

                        String opcja5g = lista.get(getrandomindex);
                        lista.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepswolne = lista.toArray(new String[0]);

                        SharedPreferences prefs5g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5g = prefs5g.edit();
                        editorr5g.putString("id5g", opcja5g); //InputString: from the EditText
                        editorr5g.commit();

                    }

                    if (lista.size()>0) {
                        int getrandomindex2 = random.nextInt(lista.size());

                        String opcja5h = lista.get(getrandomindex2);

                        lista.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepswolne = lista.toArray(new String[0]);

                        SharedPreferences prefs5h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5h = prefs5h.edit();
                        editorr5h.putString("id5h", opcja5h); //InputString: from the EditText
                        editorr5h.commit();
                    }

                    if(lista.size()>0) {

                        int getrandomindex3 = random.nextInt(lista.size());

                        String opcja5i = lista.get(getrandomindex3);
                        lista.remove(getrandomindex3);

                        TabliceCwiczen.zestawtricepswolne = lista.toArray(new String[0]);

                        SharedPreferences prefs5i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5i = prefs5i.edit();
                        editorr5i.putString("id5i", opcja5i); //InputString: from the EditText
                        editorr5i.commit();


                    }


                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecywolne));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6j = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecywolne = lista.toArray(new String[0]);

                        SharedPreferences prefs6j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6j = prefs6j.edit();
                        editorr6j.putString("id6j", opcja6j); //InputString: from the EditText
                        editorr6j.commit();

                    }

                    if (listaplecy.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy.size());

                        String opcja6k = listaplecy.get(getrandomindexp2);

                        listaplecy.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6k = prefs6k.edit();
                        editorr6k.putString("id6k", opcja6k); //InputString: from the EditText
                        editorr6k.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6l = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6l = prefs6l.edit();
                        editorr6l.putString("id6l", opcja6l); //InputString: from the EditText
                        editorr6l.commit();
                    }

                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepswolne));




                    if(listabiceps.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps.size());

                        String opcja7g = listabiceps.get(getrandomindexb1);
                        listabiceps.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7g = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7g = prefs7g.edit();
                        editorr7g.putString("id7g", opcja7g); //InputString: from the EditText
                        editorr7g.commit();

                    }


                    if(listabiceps.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps.size());

                        String opcja7h = listabiceps.get(getrandomindexb2);
                        listabiceps.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7h = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7h = prefs7h.edit();
                        editorr7h.putString("id7h", opcja7h); //InputString: from the EditText
                        editorr7h.commit();

                    }

                    if(listabiceps.size()>0) {
                        int getrandomindexb3 = randombiceps.nextInt(listabiceps.size());

                        String opcja7i = listabiceps.get(getrandomindexb3);
                        listabiceps.remove(getrandomindexb3);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7i = prefs7i.edit();
                        editorr7i.putString("id7i", opcja7i); //InputString: from the EditText
                        editorr7i.commit();

                    }

























                }

                else if( selected1==2 && selected2==1){ // jezeli bardzo wysoka intensywnosc i maszyny to
                /////////////////////NOGI//////////////////////////////////////////////
                    String opcjaa9 = TabliceCwiczen.zestaw2[1];


                    SharedPreferences prefss9 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr9 = prefss9.edit();
                    editorr9.putString("id1i", opcjaa9); //InputString: from the EditText
                    editorr9.commit();

                    String opcjaa10 = TabliceCwiczen.zestaw1[9];


                    SharedPreferences prefss10 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr10 = prefss10.edit();
                    editorr10.putString("id1j", opcjaa10); //InputString: from the EditText
                    editorr10.commit();

                    String opcjaa11 = TabliceCwiczen.zestaw1[1];


                    SharedPreferences prefss11 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr11 = prefss11.edit();
                    editorr11.putString("id1k", opcjaa11); //InputString: from the EditText
                    editorr11.commit();

                    ///////////KLATKA PIERSIOWA/////////////////////////////

                    String opcja2k = TabliceCwiczen.zestaw2[7];



                    SharedPreferences prefs2k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2k = prefs2k.edit();
                    editorr2k.putString("id2k", opcja2k); //InputString: from the EditText
                    editorr2k.commit();

                    String opcja2l = TabliceCwiczen.zestaw2[10];


                    SharedPreferences prefs2l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2l = prefs2l.edit();
                    editorr2l.putString("id2l", opcja2l); //InputString: from the EditText
                    editorr2l.commit();

                    String opcja2m = TabliceCwiczen.zestaw2[8];


                    SharedPreferences prefs2m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2m = prefs2m.edit();
                    editorr2m.putString("id2m", opcja2m); //InputString: from the EditText
                    editorr2m.commit();

                    //////////////////BRZUCH/////////////////////////////////////////////////

                    String opcja3i = TabliceCwiczen.zestaw3[7];



                    SharedPreferences prefs3i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3i = prefs3i.edit();
                    editorr3i.putString("id3i", opcja3i); //InputString: from the EditText
                    editorr3i.commit();

                    String opcja3j = TabliceCwiczen.zestaw3[2];


                    SharedPreferences prefs3j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3j = prefs3j.edit();
                    editorr3j.putString("id3j", opcja3j); //InputString: from the EditText
                    editorr3j.commit();

                    ///////////////BARKI////////////////////////////////////////////////////////


                    String opcja4i = TabliceCwiczen.zestaw4[7];



                    SharedPreferences prefs4i = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4i = prefs4i.edit();
                    editorr4i.putString("id4i", opcja4i); //InputString: from the EditText
                    editorr4i.commit();

                    String opcja4j = TabliceCwiczen.zestaw4[10];

//                    Random random = new Random();
//                    int getrandomindex = random.nextInt(TabliceCwiczen.zestaw4.length);
//                    String wylosujcwiczenie = (TabliceCwiczen.zestaw4[getrandomindex]);


                    SharedPreferences prefs4j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4j = prefs4j.edit();
                    editorr4j.putString("id4j", opcja4j); //InputString: from the EditText
                    editorr4j.commit();

                    /////////////////////TRICEPS////////////////////////////////

                    Random random = new Random();
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepsmaszyny));

                    if(lista.size()>0) {
                        int getrandomindex = random.nextInt(lista.size());

                        String opcja5j = lista.get(getrandomindex);
                        lista.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5j = prefs5j.edit();
                        editorr5j.putString("id5j", opcja5j); //InputString: from the EditText
                        editorr5j.commit();

                    }

                    if (lista.size()>0) {
                        int getrandomindex2 = random.nextInt(lista.size());

                        String opcja5k = lista.get(getrandomindex2);

                        lista.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5k = prefs5k.edit();
                        editorr5k.putString("id5k", opcja5k); //InputString: from the EditText
                        editorr5k.commit();
                    }

                    if(lista.size()>0) {

                        int getrandomindex3 = random.nextInt(lista.size());

                        String opcja5l = lista.get(getrandomindex3);
                        lista.remove(getrandomindex3);

                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5l = prefs5l.edit();
                        editorr5l.putString("id5l", opcja5l); //InputString: from the EditText
                        editorr5l.commit();


                    }

                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecymaszyny));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6m = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecymaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs6m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6m = prefs6m.edit();
                        editorr6m.putString("id6m", opcja6m); //InputString: from the EditText
                        editorr6m.commit();

                    }

                    if (listaplecy.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy.size());

                        String opcja6n = listaplecy.get(getrandomindexp2);

                        listaplecy.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6n = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6n = prefs6n.edit();
                        editorr6n.putString("id6n", opcja6n); //InputString: from the EditText
                        editorr6n.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6o = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6o = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6o = prefs6o.edit();
                        editorr6o.putString("id6o", opcja6o); //InputString: from the EditText
                        editorr6o.commit();
                    }


                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepsmaszyny));




                    if(listabiceps.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps.size());

                        String opcja7j = listabiceps.get(getrandomindexb1);
                        listabiceps.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7j = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7j = prefs7j.edit();
                        editorr7j.putString("id7j", opcja7j); //InputString: from the EditText
                        editorr7j.commit();

                    }


                    if(listabiceps.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps.size());

                        String opcja7k = listabiceps.get(getrandomindexb2);
                        listabiceps.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7k = prefs7k.edit();
                        editorr7k.putString("id7k", opcja7k); //InputString: from the EditText
                        editorr7k.commit();

                    }

                    if(listabiceps.size()>0) {
                        int getrandomindexb3 = randombiceps.nextInt(listabiceps.size());

                        String opcja7l = listabiceps.get(getrandomindexb3);
                        listabiceps.remove(getrandomindexb3);


                        TabliceCwiczen.zestawbicepswolne = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7l = prefs7l.edit();
                        editorr7l.putString("id7l", opcja7l); //InputString: from the EditText
                        editorr7l.commit();

                    }
















                }

                else if( selected1==2 && selected2==2){ // jezeli bardzo wysoka intensywnosc i zroznicowany trening

                    ///////////////////NOGI//////////////////////////////////////////

                    String opcjaa12 = TabliceCwiczen.zestaw2[1];


                    SharedPreferences prefss12 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr12 = prefss12.edit();
                    editorr12.putString("id1l", opcjaa12); //InputString: from the EditText
                    editorr12.commit();

                    String opcjaa13 = TabliceCwiczen.zestaw1[9];


                    SharedPreferences prefss13 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr13 = prefss13.edit();
                    editorr13.putString("id1m", opcjaa13); //InputString: from the EditText
                    editorr13.commit();

                    String opcjaa14 = TabliceCwiczen.zestaw1[1];


                    SharedPreferences prefss14 = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr14 = prefss14.edit();
                    editorr14.putString("id1n", opcjaa14); //InputString: from the EditText
                    editorr14.commit();

                    ////////KLATKA PIERSIOWA////////////////////////////////////////////////////////


                    String opcja2n = TabliceCwiczen.zestaw2[4];



                    SharedPreferences prefs2n = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2n = prefs2n.edit();
                    editorr2n.putString("id2n", opcja2n); //InputString: from the EditText
                    editorr2n.commit();

                    String opcja2o = TabliceCwiczen.zestaw2[3];


                    SharedPreferences prefs2o = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2o = prefs2o.edit();
                    editorr2o.putString("id2o", opcja2o); //InputString: from the EditText
                    editorr2o.commit();

                    String opcja2p = TabliceCwiczen.zestaw2[9];


                    SharedPreferences prefs2p = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2p = prefs2p.edit();
                    editorr2p.putString("id2p", opcja2p); //InputString: from the EditText
                    editorr2p.commit();

                    String opcja2r = TabliceCwiczen.zestaw2[7];


                    SharedPreferences prefs2r = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr2r = prefs2r.edit();
                    editorr2r.putString("id2r", opcja2r); //InputString: from the EditText
                    editorr2r.commit();

                    //////////////////BRZUCH/////////////////////////////////////////////////

                    String opcja3k = TabliceCwiczen.zestaw3[5];



                    SharedPreferences prefs3k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3k = prefs3k.edit();
                    editorr3k.putString("id3k", opcja3k); //InputString: from the EditText
                    editorr3k.commit();

                    String opcja3l = TabliceCwiczen.zestaw3[7];


                    SharedPreferences prefs3l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3l = prefs3l.edit();
                    editorr3l.putString("id3l", opcja3l); //InputString: from the EditText
                    editorr3l.commit();

                    String opcja3m = TabliceCwiczen.zestaw3[3];


                    SharedPreferences prefs3m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr3m = prefs3m.edit();
                    editorr3m.putString("id3m", opcja3m); //InputString: from the EditText
                    editorr3m.commit();

                    ///////////////BARKI////////////////////////////////////////////////////////


                    String opcja4k = TabliceCwiczen.zestaw4[0];



                    SharedPreferences prefs4k = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4k = prefs4k.edit();
                    editorr4k.putString("id4k", opcja4k); //InputString: from the EditText
                    editorr4k.commit();

                    String opcja4l = TabliceCwiczen.zestaw4[10];

//                    Random random = new Random();
//                    int getrandomindex = random.nextInt(TabliceCwiczen.zestaw4.length);
//                    String wylosujcwiczenie = (TabliceCwiczen.zestaw4[getrandomindex]);


                    SharedPreferences prefs4l = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4l = prefs4l.edit();
                    editorr4l.putString("id4l", opcja4l); //InputString: from the EditText
                    editorr4l.commit();

                    String opcja4m = TabliceCwiczen.zestaw4[7];

//                    Random random = new Random();
//                    int getrandomindex = random.nextInt(TabliceCwiczen.zestaw4.length);
//                    String wylosujcwiczenie = (TabliceCwiczen.zestaw4[getrandomindex]);


                    SharedPreferences prefs4m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                    SharedPreferences.Editor editorr4m = prefs4m.edit();
                    editorr4m.putString("id4m", opcja4m); //InputString: from the EditText
                    editorr4m.commit();

                    /////////////////////TRICEPS////////////////////////////////

                    Random random = new Random();
                    List<String> lista = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepsmaszyny));
                    List<String> lista2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawtricepswolne));


                    if(lista2.size()>0) {
                        int getrandomindex = random.nextInt(lista2.size());

                        String opcja5m = lista2.get(getrandomindex);
                        lista2.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepswolne = lista2.toArray(new String[0]);

                        SharedPreferences prefs5m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5m = prefs5m.edit();
                        editorr5m.putString("id5m", opcja5m); //InputString: from the EditText
                        editorr5m.commit();

                    }

                    if (lista.size()>0) {
                        int getrandomindex2 = random.nextInt(lista.size());

                        String opcja5n = lista.get(getrandomindex2);

                        lista.remove(getrandomindex2);

                        TabliceCwiczen.zestawtricepsmaszyny = lista.toArray(new String[0]);

                        SharedPreferences prefs5n = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5n = prefs5n.edit();
                        editorr5n.putString("id5n", opcja5n); //InputString: from the EditText
                        editorr5n.commit();
                    }

                    if(lista2.size()>0) {
                        int getrandomindex = random.nextInt(lista2.size());

                        String opcja5o = lista2.get(getrandomindex);
                        lista2.remove(getrandomindex);


                        TabliceCwiczen.zestawtricepswolne = lista2.toArray(new String[0]);

                        SharedPreferences prefs5o = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr5o = prefs5o.edit();
                        editorr5o.putString("id5o", opcja5o); //InputString: from the EditText
                        editorr5o.commit();

                    }


                    ////////////////////PLECY////////////////////////////////

                    Random randomplecy = new Random();
                    List<String> listaplecy = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecywolne));
                    List<String> listaplecy2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawplecymaszyny));



                    if(listaplecy.size()>0) {
                        int getrandomindexp = randomplecy.nextInt(listaplecy.size());

                        String opcja6p = listaplecy.get(getrandomindexp);
                        listaplecy.remove(getrandomindexp);


                        TabliceCwiczen.zestawplecywolne = lista.toArray(new String[0]);

                        SharedPreferences prefs6p = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6p = prefs6p.edit();
                        editorr6p.putString("id6p", opcja6p); //InputString: from the EditText
                        editorr6p.commit();

                    }

                    if (listaplecy2.size()>0) {
                        int getrandomindexp2 = randomplecy.nextInt(listaplecy2.size());

                        String opcja6r = listaplecy2.get(getrandomindexp2);

                        listaplecy2.remove(getrandomindexp2);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy2.toArray(new String[0]);

                        SharedPreferences prefs6r = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6r = prefs6r.edit();
                        editorr6r.putString("id6r", opcja6r); //InputString: from the EditText
                        editorr6r.commit();
                    }



                    if (listaplecy.size()>0) {
                        int getrandomindexp3 = randomplecy.nextInt(listaplecy.size());

                        String opcja6s = listaplecy.get(getrandomindexp3);

                        listaplecy.remove(getrandomindexp3);

                        TabliceCwiczen.zestawplecywolne = listaplecy.toArray(new String[0]);

                        SharedPreferences prefs6s = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6s = prefs6s.edit();
                        editorr6s.putString("id6s", opcja6s); //InputString: from the EditText
                        editorr6s.commit();
                    }


                    if (listaplecy2.size()>0) {
                        int getrandomindexp4 = randomplecy.nextInt(listaplecy2.size());

                        String opcja6t = listaplecy2.get(getrandomindexp4);

                        listaplecy2.remove(getrandomindexp4);

                        TabliceCwiczen.zestawplecymaszyny = listaplecy2.toArray(new String[0]);

                        SharedPreferences prefs6t = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr6t = prefs6t.edit();
                        editorr6t.putString("id6t", opcja6t); //InputString: from the EditText
                        editorr6t.commit();
                    }

                    /////////////////////BICEPS////////////////////////////////

                    Random randombiceps = new Random();
                    List<String> listabiceps = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepsmaszyny));
                    List<String> listabiceps2 = new ArrayList<String>(Arrays.asList(TabliceCwiczen.zestawbicepswolne));





                    if(listabiceps2.size()>0) {
                        int getrandomindexb1 = randombiceps.nextInt(listabiceps2.size());

                        String opcja7m = listabiceps2.get(getrandomindexb1);
                        listabiceps2.remove(getrandomindexb1);


                        TabliceCwiczen.zestawbicepswolne = listabiceps2.toArray(new String[0]);

                        SharedPreferences prefs7m = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7m = prefs7m.edit();
                        editorr7m.putString("id7m", opcja7m); //InputString: from the EditText
                        editorr7m.commit();

                    }


                    if(listabiceps.size()>0) {
                        int getrandomindexb2 = randombiceps.nextInt(listabiceps.size());

                        String opcja7n = listabiceps.get(getrandomindexb2);
                        listabiceps.remove(getrandomindexb2);


                        TabliceCwiczen.zestawbicepsmaszyny = listabiceps.toArray(new String[0]);

                        SharedPreferences prefs7n = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7n = prefs7n.edit();
                        editorr7n.putString("id7n", opcja7n); //InputString: from the EditText
                        editorr7n.commit();

                    }

                    if(listabiceps2.size()>0) {
                        int getrandomindexb3 = randombiceps.nextInt(listabiceps2.size());

                        String opcja7o = listabiceps2.get(getrandomindexb3);
                        listabiceps2.remove(getrandomindexb3);


                        TabliceCwiczen.zestawbicepswolne = listabiceps2.toArray(new String[0]);

                        SharedPreferences prefs7o = PreferenceManager.getDefaultSharedPreferences(PlanTreningowy.this);
                        SharedPreferences.Editor editorr7o = prefs7o.edit();
                        editorr7o.putString("id7o", opcja7o); //InputString: from the EditText
                        editorr7o.commit();

                    }









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
        alertDialog.show();



    }

    public void startFormularz3(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twój przedział wiekowy.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz3(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {



                if(i==0){



                }
                if(i==1){


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
        alertDialog.show();



    }

    public void startFormularz4(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jakie jest twoje BMI( Wskaźnik masy ciała) ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz4(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){

                }
                if(i==3){

                }
                if(i==4){

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
        alertDialog.show();



    }

    public void startFormularz5(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Potrafisz określić poziom swojej tkanki tłuszczowej ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz5(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){

                }
                if(i==3){

                }
                if(i==4){

                }
                if(i==5){


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
        alertDialog.show();



    }

    public void startFormularz6(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Twój staż treningowy.");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz6(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){

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
        alertDialog.show();



    }

    public void startFormularz7(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile razy w tygodniu zamierzasz trenować ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz7(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){

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
        alertDialog.show();



    }

    public void startFormularz8(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Rozwój jakich mięśni jest dla ciebie najważniejszy ?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz8(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

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
        alertDialog.show();



    }



    public void startFormularz9(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Masz jakiekolwiek przeciwwskazania do" + " " + "wykonywania poszczególnych ćwiczeń ?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz9(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

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
        alertDialog.show();



    }

    public void startFormularz10(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jaki rodzaj treningu preferujesz?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz10(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                selected2=i;

                if(selected2==0){

                }
                if(selected2==1){

                }
                if(selected2==2){


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
        alertDialog.show();



    }

    public void startFormularz11(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Ile czasu zamierzasz poświęcić na trening w danym dniu?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz11(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if (i==2){

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
        alertDialog.show();



    }

    public void startFormularz12(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Czy jesteś w stanie wykonywać ćwiczenia z wykorzystaniem" + " " + "własnego ciężaru ciała?");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz12(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if (i==2){

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
        alertDialog.show();



    }

    public void startFormularz13(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy zamierzasz stosować dietę w treningu siłowym?");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz13(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

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
        alertDialog.show();



    }

    public void startFormularz14(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        TextView textView = new TextView(PlanTreningowy.this);
        textView.setText("Na jaki rodzaj treningu aerobowego kładziesz" + " " + "największy nacisk? ");
        textView.setPadding(20,10,20,10);
        textView.setTypeface(null,Typeface.BOLD);
        textView.setTextSize(18);
        textView.setTextColor(Color.BLACK);
        dialog.setCustomTitle(textView);
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz14(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){


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
        alertDialog.show();



    }


    public void startFormularz15(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Na jaki rodzaj treningu siłowego kładziesz największy nacisk? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz15(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if(i==2){

                }

                if (i==3){


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
        alertDialog.show();



    }

    public void startFormularz16(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Czy zamierzasz uczęszczać na zajęcia fitness? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz16(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if (i==2){


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
        alertDialog.show();



    }


    public void startFormularz17(){

        AlertDialog.Builder dialog  = new AlertDialog.Builder(PlanTreningowy.this); // builder którzy tworzy podstawowy widok listy AlertDialog
        dialog.setTitle("Jaki trening cardio preferujesz? ");
        dialog.setSingleChoiceItems(odpowiedz111.getOdpowiedz17(), 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if(i==0){

                }
                if(i==1){

                }
                if (i==2){


                }




            }


        });

        dialog.setPositiveButton("Dalej", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent1 = new Intent(PlanTreningowy.this,GotowyPlanTreningowy.class);
                startActivity(intent1);




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
