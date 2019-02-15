package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Triceps extends AppCompatActivity {


    public int[] zdjeciatriceps =  {R.drawable.tricepspompkinaporeczach,
            R.drawable.tricepsprostowanieprzedramieniawpioniezhantla,
            R.drawable.tricepsprostowanieprzedramionzgryfemprostymtrzymanymnachwytemwyciaggorny,
            R.drawable.tricepsprostowanieprzedramionzlinazwyciagudolnegostojac,
            R.drawable.tricepsprostowanieramionzhantlamizasiebiewopadzietulowia,
            R.drawable.tricepsprostowanieramionzlinkamiwyciagugornego,
            R.drawable.tricepswyciskaniefrancuskiehantlami,
            R.drawable.tricepswyciskaniefrancuskiezprzenoszeniemramionzaglowe,
            R.drawable.tricepswyciskaniesztangiwaskimchwytem,
            R.drawable.tricepsprostowanieramieniajednoraczzwyciagugornego,
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);


        String[] triceps = {"Pompki na poręczach","Prostowanie przedramienia w pionie z hantlą","Prostowanie przedramion z gryfem prostym trzymanym nachwytem - wyciąg górny",
                "Prostowanie przedramion z liną z wyciągu dolnego stojąc","Prostowanie ramion z hantlami za siebie w opadzie tułowia","Prostowanie ramion z linkami z wyciągu górnego",
                "Wyciskanie francuskie hantlami","Wyciskanie francuskie z przenoszeniem ramion za głowę","Wyciskanie sztangi wąskim chwytem",
                "Prostowanie ramienia jednorącz z wyciągu górnego"};






ListAdapter mojadapter5 = new CustomAdapterTriceps(this,triceps,zdjeciatriceps);
        ListView referencja5 = (ListView)findViewById(R.id.listacwiczen);

        referencja5.setAdapter(mojadapter5);







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




