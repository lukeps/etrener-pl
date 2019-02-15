package com.example.luke.trener;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class Logowanie1 extends AppCompatActivity {

    private EditText email1;
    private EditText haslo1;
    private Button przyciskrejestracja2;
    public FirebaseAuth firebaseAuth2;
    Logowanie odwolaniefirebase = new Logowanie();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie1);

        firebaseAuth2 = odwolaniefirebase.getFirebaseAuth();
        firebaseAuth2 = FirebaseAuth.getInstance();











        email1 = (EditText)findViewById(R.id.emaillogowanie);
        haslo1 = (EditText)findViewById(R.id.haslologowanie);
        przyciskrejestracja2 = (Button) findViewById(R.id.przycisklogowanie);

        przyciskrejestracja2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Logowanie2();



            }
        });








    }






    private void Logowanie2(){





        String  email = email1.getText().toString().trim();
        String haslo = haslo1.getText().toString().trim();
        if (email.isEmpty()){
            Toast.makeText(this,"Proszę podać email",Toast.LENGTH_SHORT).show();

            return;
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

            Toast.makeText(this,"Proszę podać właściwy adres e-mail",Toast.LENGTH_SHORT).show();
            return;


        }

        if (haslo.isEmpty()){

            Toast.makeText(this,"Proszę podać hasło",Toast.LENGTH_SHORT).show();

            return;



        }

        if(haslo.length()<6){
            Toast.makeText(this,"Hasło musi posiadać conajmniej 6 znaków",Toast.LENGTH_SHORT).show();


        }

        else{

            Intent przeslijtekst = new Intent(this,MainActivity.class);
            przeslijtekst.putExtra("text",email1.getText().toString());
            startActivity(przeslijtekst);



        }

        firebaseAuth2.signInWithEmailAndPassword(email,haslo).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {




                    if (task.isSuccessful()) {
                        finish();

                        startActivity(new Intent(getApplicationContext(), MainActivity.class));


                        return;


                    }

                    else{

                        Toast.makeText(getApplicationContext(),"Błędny e-mail lub hasło. Spróbuj ponownie.",Toast.LENGTH_SHORT).show();



                    }



                }








        });









    }






}
