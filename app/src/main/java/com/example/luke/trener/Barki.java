package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;





public class Barki extends AppCompatActivity {



    public int[] zdjeciabarki =  {R.drawable.podciaganiesztangipodbrode,
        R.drawable.unoszenieramionwbokhantle,
        R.drawable.przyciaganielinyzwyciagugornegodoklatkipiersiowej,
        R.drawable.unoszenieramionwprzodhantle,
        R.drawable.unoszenieramionwprzodwyciagdolny,
        R.drawable.wyciskaniehantlinadglowestojac,
        R.drawable.wyciskaniehantlinadglowezrotacja,
        R.drawable.wyciskanieramionnadglowesiedzacmaszyna,
        R.drawable.wyciskanieramionwbokwopadzietulowia,
        R.drawable.wyciskaniesztanginamaszyniesmithasiedzac,
        R.drawable.wyciskaniesztangizzaglowystojac};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);



        String[] barki = {"Podciaganie sztangi pod brodę","Unoszenie ramion w bok - hantle","Przyciaganie liny z wyciągu górnego do klatki piersiowej",
                            "Unoszenie ramion w przód - hantle","Unoszenie ramion w przód - wyciąg dolny","Wyciskanie hantli nad głowę stojąc",
                               "Wyciskanie hantli nad głowę z rotacją","Wyciskanie ramion nad głowę siedząc - maszyna","Wyciskanie  w bok w opadzie tułowia",
                                "Wyciskanie sztangi na maszynie smitha siedząc","Wyciskanie sztangi zza głowy stojąc"};








        ListAdapter mojadapter = new CustomAdapterCwiczenia(this, barki,zdjeciabarki);
        ListView referencja1 = (ListView)findViewById(R.id.listacwiczen);

        referencja1.setAdapter(mojadapter);







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
