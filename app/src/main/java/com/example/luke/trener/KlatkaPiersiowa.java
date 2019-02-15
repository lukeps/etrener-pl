package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class KlatkaPiersiowa extends AppCompatActivity {


    public int[] zdjeciaklatka =  {R.drawable.klatkafloorpress,
            R.drawable.klatkapompki,
            R.drawable.klatkapompkinaporeczach,
            R.drawable.klatkaprzenoszeniehantlazaglowe,
            R.drawable.klatkarozpietkinamaszynie,
            R.drawable.klatkarozpietkizhantlamilawkadodatnia,
            R.drawable.klatkarozpietkizwykorzystaniemwyciagudolnego,
            R.drawable.klatkawyciskaniehantlinalawcedodatniej,
            R.drawable.klatkawyciskaniehantlinalawceplaskiej,
            R.drawable.klatkawyciskanienalawceskosnejglowawdol,
            R.drawable.klatkawyciskaniesztanginalawceplaskiej};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);


        String[] klatka = {"Floor press","Pompki","Pompki na poręczach",
                "Przenoszenie hantla za głowę","Rozpiętki na maszynie","Rozpiętki z hantlami - ławka dodatnia",
                "Rozpiętki z wykorzystaniem wyciągu dolnego","Wyciskanie hantli na ławce dodatniej","Wyciskanie hantli na ławce płaskiej",
                "Wyciskanie na ławce skośnej głową w dół","Wyciskanie sztangi na ławce płaskiej"};






        ListAdapter mojadapter2 = new CustomAdapterKlatkaPiersiowa(this,klatka,zdjeciaklatka);

        ListView referencja2 = (ListView)findViewById(R.id.listacwiczen);

        referencja2.setAdapter(mojadapter2);







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



        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}



