package com.example.luke.trener;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ListAdapter;
import android.support.v7.app.ActionBar;
public class AtlasCwiczen extends AppCompatActivity {

      final int[] zdjecia =


            {R.drawable.barki1,
                    R.drawable.biceps,
                    R.drawable.brzuch,
                    R.drawable.klata,
                    R.drawable.nogi,
                    R.drawable.plecy,

                    R.drawable.tricep

            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list); // ustawienie podstawowego widoku listy z widgetu, za pomocą tego widoku, będzie rozmieszczany poszczególny wiersz z własnej listy ( custom_row)

        ActionBar actionbar = getSupportActionBar(); // pobranie i ustawienie widoku Action Bara w aktywnosci
        actionbar.show();


        String[] cwiczenia1 =


                {"Barki","Biceps","Brzuch","Klatka Piersiowa", "Nogi", "Plecy","Triceps"};




        ListAdapter lista = new CustomAdapter(this,cwiczenia1,zdjecia); // przypisanie do listy własnego adaptera, z parametrami tablic ćwiczen i zdjęć
       ListView mojaalista = (ListView) findViewById(R.id.listaaa); // pobranie referencji do podstawowej Listy
        mojaalista.setAdapter(lista); // ustawiamy adapter własnej listy, do listy podstawowej

        mojaalista.setOnItemClickListener(new AdapterView.OnItemClickListener() {  // ustawienie nasłuchiwacza któy będzie czekał na kliknięcie danego wiersza w liście
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {  // metoda OnItemClick umożliwia reakcje na kliknięcie któregoś z elementu listy, w zależności który element listy zostanie naciśnięty, to wykona się dana akcja. W tym przypadku przejście do poszczególnych aktywności.
                if (i==0){

                    Intent intent1 = new Intent(AtlasCwiczen.this, Barki.class);
                    startActivity(intent1);

                }

                else if (i==1){

                    Intent intent2 = new Intent(AtlasCwiczen.this, Biceps.class);
                    startActivity(intent2);

                }

                else if (i==2){
                    Intent intent8 = new Intent(AtlasCwiczen.this, Brzuch.class);
                    startActivity(intent8);
                }

                else if (i==3){

                    Intent intent3 = new Intent(AtlasCwiczen.this, KlatkaPiersiowa.class);
                    startActivity(intent3);

                }


                else if (i==4){

                    Intent intent4 = new Intent(AtlasCwiczen.this, Nogi.class);
                    startActivity(intent4);
                }

                else if (i==5){

                    Intent intent5 = new Intent(AtlasCwiczen.this, Plecy.class);
                    startActivity(intent5);
                }



                else {

                    Intent intent7 = new Intent (AtlasCwiczen.this, Triceps.class);
                    startActivity(intent7);
                }
            }
        });





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_glowne_actionbar, menu); // polaczenie widoku ( menu utworzonego w XML) z kodem javy // służy do utworzenia action bara
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.onas){ // jezeli kliknieto w opcje O nas, to utworz nowa aktywnosc i przejdz do niej // reakcja na klikniecie elementu w menu action bara

            Intent aktywnosc_o_nas = new Intent (this, oNas.class);
            startActivity(aktywnosc_o_nas);
        }

        else if (item.getItemId()==R.id.wyloguj){

            startActivity(new Intent(this,Logowanie1.class));
        }

        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }





}
