package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Brzuch extends AppCompatActivity {

    public int[] zdjeciabrzuch =  {R.drawable.izometrycznyskurczbrzucha,
            R.drawable.prostowanienoglezac,
            R.drawable.przyciaganiekolandoklatkiwzwisienadrazku,
            R.drawable.rewersy,
            R.drawable.rotacjabocznazwyciagu,
            R.drawable.rotacjezguma,
            R.drawable.rowerek,
            R.drawable.scyzoryk,
            R.drawable.spieciabrzucha,
            R.drawable.unoszenienogdodrazka,
            R.drawable.unoszenietulowiazpodloza};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);



        String[] brzuch = {"Izometryczny skurcz brzucha","Prostowanie nóg leżąc",
                "Przyciąganie kolan do klatki w zwisie na drążku","Rewersy","Rotacja boczna z wyciągu",
                "Rotacje z gumą","Rowerek","Scyzoryk",
                "Spięcia brzucha","Unoszenie nóg do drążka","Unoszenie tułowia z podłoża"};





        ListAdapter adapterbrzuch = new CustomAdapterBrzuch(this,brzuch,zdjeciabrzuch);

        ListView referencja1 = (ListView)findViewById(R.id.listacwiczen);

        referencja1.setAdapter(adapterbrzuch);







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

