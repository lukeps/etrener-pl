package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Biceps extends AppCompatActivity {



    public int[] zdjeciabiceps =  {R.drawable.bicepsuginanieramionnachwytemhantle,
            R.drawable.bicepsuginanieramionzesztangawoparciuolawke,
            R.drawable.bicepsuginanieramionzhantlamirotacja,
            R.drawable.bicepszginanieprzedramieniazhantlemlokiecopartynaudzie,
            R.drawable.bicepszginanieprzedramionstojawyciaggorny,
            R.drawable.bicepszginanieprzedramionwchwyciemlotkowymsiedzac,
            R.drawable.bicepszginanieprzedramionzgryfemwyciaggorny,
            R.drawable.bicepszginanieprzedramionzhantlamichwytmlotkowy,
            R.drawable.bicepszginanieprzedramionzlinazwyciagudolnego,
            R.drawable.bicepszginanieramionzgryfemlamanymnamodlitewniku,
            R.drawable.bicepszginanieramionzhantlaminamodlitewnikuchwytmlotkowy};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);



        String[] biceps = {"Uginanie ramion nachwytem - hantle",
                "Uginanie ramion ze sztangą w oparciu o ławkę","Uginanie ramion z hantlami - rotacja","Zginanie przedramienia z hantlem - łokieć oparty na udzie",
                "Zginanie przedramion stojąc - wyciąg górny","Zginanie przedramion w chwycie młotkowym siedząc","Zginanie przedramion  z gryfem - wyciąg górny",
                "Zginanie przedramion z hantlami chwytem młotkowym","Zginanie przedramion z liną z wyciągu dolnego","Zginanie ramion z gryfem łamanym na modlitewniku",
                  "Zginanie ramion z hantlami na modlitewniku chwytem młotkowym"};





        ListAdapter adapterbiceps = new CustomAdapterBiceps(this,biceps,zdjeciabiceps);

        ListView referencja = (ListView)findViewById(R.id.listacwiczen);

        referencja.setAdapter(adapterbiceps);







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

