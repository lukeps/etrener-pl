package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Plecy extends AppCompatActivity {


    public int[] zdjeciaplecy =  {R.drawable.plecyklasycznymartwyciag,
            R.drawable.plecypodciaganiechwytemmlotkowym,
            R.drawable.plecypodciaganienadrazkupodchwytem,
            R.drawable.plecysciaganiechwytemneutralnymzwyciagugornego,
            R.drawable.plecysciaganiedrazkawyciagugornego,
            R.drawable.plecywioslowaniehantlamiwopadzietulowia,
            R.drawable.plecywioslowaniehantlamiwoparciuolawkeskosna,
            R.drawable.plecywioslowaniehantlawoparciuolaweczke,
            R.drawable.plecywioslowaniesztanganachwytempelnymwopadzietulowia,
            R.drawable.plecywioslowaniewpodporze,
            R.drawable.plecywioslowaniesiedzac};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);


        String[] plecy = {"Klasyczny martwy ciąg","Podciąganie chwytem młotkowym","Podciąganie na drążku podchwytem",
                "Ściąganie nachwytem neutralnym z wyciągu górnego","Ściąganie drążka wyciągu górnego","Wiosłowanie hantlami w opadzie tułowia",
                "Wiosłowanie hantlami w oparciu o ławkę skośną","Wiosłowanie hantlami w oparciu o ławeczkę","Wiosłowanie sztangą nachwytem pełnym w opadzie tułowia ",
                "Wiosłowanie w podporze","Wiosłowanie siedząc"};






ListAdapter mojadapter4 = new CustomAdapterPlecy(this,plecy,zdjeciaplecy);
        ListView referencja4 = (ListView)findViewById(R.id.listacwiczen);

        referencja4.setAdapter(mojadapter4);







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



