package com.example.luke.trener;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.google.firebase.auth.FirebaseAuthEmailException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class Logowanie extends AppCompatActivity {

    public Logowanie(){

    };

    private EditText email1;
    private EditText haslo1;
    private Button przyciskrejestracja1;
    private TextView logowanie1;
    public  FirebaseAuth FirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logowanie);



        FirebaseAuth = FirebaseAuth.getInstance();

        email1 = (EditText)findViewById(R.id.email);
        haslo1 = (EditText)findViewById(R.id.haslo);
        przyciskrejestracja1 = (Button) findViewById(R.id.przyciskrejestracja);
        logowanie1 = (TextView) findViewById(R.id.logowanie);




        przyciskrejestracja1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Rejestracja();

            }
        });

        logowanie1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AktywnoscLogowanie();

            }
        });


    }


    private void AktywnoscLogowanie(){

        Intent logowanko = new Intent (this,Logowanie1.class);
        startActivity(logowanko);

    }



    public void Rejestracja(){

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

        FirebaseAuth.createUserWithEmailAndPassword(email,haslo).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()){

                    Toast.makeText(Logowanie.this, "Rejestracja powiodła się !",Toast.LENGTH_SHORT).show();
                }

                else if(task.getException() instanceof FirebaseAuthUserCollisionException){
                    Toast.makeText(Logowanie.this, "Wybrany e-mail jest zajęty! Spróbuj ponownie",Toast.LENGTH_SHORT).show();


                }

                else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }





            }
        });





    }

    public FirebaseAuth getFirebaseAuth(){

        return this.FirebaseAuth;
    }


}

