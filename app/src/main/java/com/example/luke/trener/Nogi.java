package com.example.luke.trener;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.ListView;

public class Nogi extends AppCompatActivity {
    public int[] zdjecianogi =  {R.drawable.nogiprzysiadnamaszyniesmitha,
            R.drawable.nogiprzysiadwykrocznyznogazakrocznanapodwyzszeniuzhantlami,
            R.drawable.nogiprzysiadzesztanganaplecach,
            R.drawable.nogiuginanienogzhantlawlezeniu,
            R.drawable.nogiunoszeniebioderzesztanga,
            R.drawable.nogiwspiecianapalcachnamaszynie,
            R.drawable.nogiwyprostykolannamaszyniesiedzac,
            R.drawable.nogiwypychaniesuwnicyjednonoz,
            R.drawable.nogizakrokizhantlami,
            R.drawable.nogizginanienognamaszynielezac
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cwiczen);


        String[] nogi = {"Przysiad na maszynie smitha","Przysiad wykroczny z nogą zakroczną na podwyższeniu z hantlami","Przysiad ze sztangą na plecach",
                "Uginanie nóg z hantlą w leżeniu","Unoszenie bioder ze sztangą","Wspięcia na palcach na maszynie",
                "Wyprosty kolan na maszynie siedząc","Wypychanie suwnicy jednonóż","Zakroki z hantlami",
                "Zginanie nogami na maszynie leżąc"};






        ListAdapter mojadapter3 = new CustomAdapterNogi(this,nogi,zdjecianogi);
        ListView referencja3 = (ListView)findViewById(R.id.listacwiczen);

        referencja3.setAdapter(mojadapter3);







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



