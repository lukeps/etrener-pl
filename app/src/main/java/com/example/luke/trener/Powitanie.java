package com.example.luke.trener;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;



public class Powitanie extends AppCompatActivity {

    private EditText tekst;
    private Button powitanie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_powitanie);



        tekst = (EditText)findViewById(R.id.editText); // pobiera id do widgetu EditText
        powitanie = (Button)findViewById(R.id.button); // pobiera id widgetu przycisku

        powitanie.setOnClickListener(new View.OnClickListener() {  // ustawia nasłuchiwacza przycisku ( reakcja na kliknięcie przycisku)
            @Override
            public void onClick(View view) {

                if(!tekst.getText().toString().isEmpty()){  // jeżeli w zmiennej referencyjnej pola tekstowego zostały wpisane jakieś znaki  to utwórz nową intencję do drugiej aktywności gdzie przekazujesz te wpisane znaki, a następnie uruchamiasz nową aktywność

                    Intent  intencja = new Intent(Powitanie.this, MainActivity.class);
                    intencja.putExtra("tekst", tekst.getText().toString());
                    startActivity(intencja);

                }

                else {
                    Toast.makeText(Powitanie.this, "Aby przejść dalej, podaj swoję imię", Toast.LENGTH_SHORT).show(); // jeżeli nic nie wpisałeś i nacisnąłeś przycisk to nie przejdziesz dalej, zostanie wyświetlony napis i musisz wpisac jeszcze raz.
                }

            }
        });
    }
}
