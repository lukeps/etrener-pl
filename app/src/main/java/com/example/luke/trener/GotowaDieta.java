package com.example.luke.trener;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;

public  class GotowaDieta extends AppCompatActivity {


    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    Calendar obecnadata = Calendar.getInstance();
    Calendar obecnadata2 = Calendar.getInstance();

    TextView odczytaniedaty;
    TextView odczytaniedaty2;
    TextView sniadanie1;
    TextView sniadaniedrugie1;
    TextView obiad1;
    TextView podwieczorek1;
    TextView kolacja1;
    TextView sniadanie2;
    TextView sniadaniedrugie2;
    TextView obiad2;
    TextView podwieczorek2;
    TextView kolacja2;
    TextView sniadanie3;
    TextView sniadaniedrugie3;
    TextView obiad3;
    TextView podwieczorek3;
    TextView kolacja3;
    TextView sniadanie4;
    TextView sniadaniedrugie4;
    TextView obiad4;
    TextView podwieczorek4;
    TextView kolacja4;
    TextView sniadanie5;
    TextView sniadaniedrugie5;
    TextView obiad5;
    TextView podwieczorek5;
    TextView kolacja5;


    TextView godzinasniadanie;
    TextView godzinasniadaniedrugie;
    TextView godzinaobiad;
    TextView godzinapodwieczorek;
    TextView godzinakolacja;
    TextView godzinasniadanie2;
    TextView godzinasniadaniedrugie2;
    TextView godzinaobiad2;
    TextView godzinapodwieczorek2;
    TextView godzinakolacja2;
    TextView godzinasniadanie3;
    TextView godzinasniadaniedrugie3;
    TextView godzinaobiad3;
    TextView godzinapodwieczorek3;
    TextView godzinakolacja3;
    TextView godzinasniadanie4;
    TextView godzinasniadaniedrugie4;
    TextView godzinaobiad4;
    TextView godzinapodwieczorek4;
    TextView godzinakolacja4;
    TextView godzinasniadanie5;
    TextView godzinasniadaniedrugie5;
    TextView godzinaobiad5;
    TextView godzinapodwieczorek5;
    TextView godzinakolacja5;





    Button przycisk;
    ScrollView scrollview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gotowa_dieta);



        odczytaniedaty = (TextView)findViewById(R.id.datadieta);
        odczytaniedaty2 = (TextView)findViewById(R.id.datadieta1);
        sniadanie1 = (TextView)findViewById(R.id.sniadanie1);
        sniadaniedrugie1 = (TextView)findViewById(R.id.sniadaniedrugie1);
        obiad1 = (TextView)findViewById(R.id.obiad1);
        podwieczorek1 = (TextView)findViewById(R.id.podwieczorek1);
        kolacja1 = (TextView)findViewById(R.id.kolacja1);
        sniadanie2 = (TextView)findViewById(R.id.sniadanie2);
        sniadaniedrugie2 = (TextView)findViewById(R.id.sniadaniedrugie2);
        obiad2 = (TextView)findViewById(R.id.obiad2);
        podwieczorek2 = (TextView)findViewById(R.id.podwieczorek2);
        kolacja2 = (TextView)findViewById(R.id.kolacja2);
        sniadanie3= (TextView)findViewById(R.id.sniadanie3);
        sniadaniedrugie3 = (TextView)findViewById(R.id.sniadaniedrugie3);
        obiad3 = (TextView)findViewById(R.id.obiad3);
        podwieczorek3 = (TextView)findViewById(R.id.podwieczorek3);
        kolacja3 = (TextView)findViewById(R.id.kolacja3);
        sniadanie4= (TextView)findViewById(R.id.sniadanie4);
        sniadaniedrugie4 = (TextView)findViewById(R.id.sniadaniedrugie4);
        obiad4 = (TextView)findViewById(R.id.obiad4);
        podwieczorek4 = (TextView)findViewById(R.id.podwieczorek4);
        kolacja4 = (TextView)findViewById(R.id.kolacja4);
        sniadanie5= (TextView)findViewById(R.id.sniadanie5);
        sniadaniedrugie5 = (TextView)findViewById(R.id.sniadaniedrugie5);
        obiad5 = (TextView)findViewById(R.id.obiad5);
        podwieczorek5 = (TextView)findViewById(R.id.podwieczorek5);
        kolacja5 = (TextView)findViewById(R.id.kolacja5);
        przycisk = (Button)findViewById(R.id.screenshot);
        scrollview = (ScrollView)findViewById(R.id.scrollView);

        godzinasniadanie = (TextView)findViewById(R.id.godzinasniadanie);
        godzinasniadanie2 = (TextView)findViewById(R.id.godzinasniadanie2);
        godzinasniadanie3 = (TextView)findViewById(R.id.godzinasniadanie3);
        godzinasniadanie4 = (TextView)findViewById(R.id.godzinasniadanie4);
        godzinasniadanie5 = (TextView)findViewById(R.id.godzinasniadanie5);

        godzinasniadaniedrugie = (TextView)findViewById(R.id.godzinadrugiesniadanie);
        godzinasniadaniedrugie2 = (TextView)findViewById(R.id.godzinadrugiesniadanie2);
        godzinasniadaniedrugie3 = (TextView)findViewById(R.id.godzinadrugiesniadanie3);
        godzinasniadaniedrugie4 = (TextView)findViewById(R.id.godzinadrugiesniadanie4);
        godzinasniadaniedrugie5 = (TextView)findViewById(R.id.godzinadrugiesniadanie5);

        godzinaobiad = (TextView)findViewById(R.id.godzinaobiad);
        godzinaobiad2 = (TextView)findViewById(R.id.godzinaobiad2);
        godzinaobiad3 = (TextView)findViewById(R.id.godzinaobiad3);
        godzinaobiad4 = (TextView)findViewById(R.id.godzinaobiad4);
        godzinaobiad5 = (TextView)findViewById(R.id.godzinaobiad5);

        godzinapodwieczorek = (TextView)findViewById(R.id.godzinapodwieczorek);
        godzinapodwieczorek2 = (TextView)findViewById(R.id.godzinapodwieczorek2);
        godzinapodwieczorek3 = (TextView)findViewById(R.id.godzinapodwieczorek3);
        godzinapodwieczorek4 = (TextView)findViewById(R.id.godzinapodwieczorek4);
        godzinapodwieczorek5 = (TextView)findViewById(R.id.godzinapodwieczorek5);

        godzinakolacja = (TextView)findViewById(R.id.godzinakolacja);
        godzinakolacja2 = (TextView)findViewById(R.id.godzinakolacja2);
        godzinakolacja3 = (TextView)findViewById(R.id.godzinakolacja3);
        godzinakolacja4 = (TextView)findViewById(R.id.godzinakolacja4);
        godzinakolacja5 = (TextView)findViewById(R.id.godzinakolacja5);





        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder(); StrictMode.setVmPolicy(builder.build()); // zapewnia dostęp do zapisu  np w galerii w wersjach =>24 SDK androida w innym wypadku wyrzuci wyjątek o braku mozliwosci dosdtepuy

        if (ContextCompat.checkSelfPermission(this, // warunki zapewniające dostęp do praw zapisu i odczytu plików w SDK od 24 androida trzeba ustalic programowo w kodzie, w manifescie działa lecz w wersjach nizszych niz 24
                android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {



            } else {


                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_READ_CONTACTS);


            }
        }








        zwrocDate7DniwPrzod();
        ustalDietePon();
        ustalDieteWt();
        ustalDieteSr();
        ustalDieteCz();
        ustalDietePt();
        ustalGodzinyPosilkow();


        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                drukuj();

            }
        });
    }

    void zwrocDate7DniwPrzod(){
        int mRok = obecnadata.get(Calendar.YEAR);
        int mMiesiac = obecnadata.get(Calendar.MONTH);
        int mDzien = obecnadata.get(Calendar.DAY_OF_MONTH);


        obecnadata.set(mRok, mMiesiac, mDzien);

        obecnadata2.add(Calendar.DATE,7);

        int mRok2 = obecnadata2.get(Calendar.YEAR);
        int mMiesiac2 = obecnadata2.get(Calendar.MONTH);
        int mDzien2 = obecnadata2.get(Calendar.DAY_OF_MONTH);
        obecnadata2.set(mRok2, mMiesiac2, mDzien2);



        odczytaniedaty.setText(mDzien + "-" + (mMiesiac + 1) + "-" + mRok);
        odczytaniedaty2.setText((mDzien2) +  "-" + (mMiesiac2 +1 )  + "-" + mRok2);
    }








    private void ustalDietePon(){ // metoda ustawiajaca diete w zaleznosci od zaznaczonej opcji
        if(Dieta.zaznaczonyindex==0){

            Dieta.setSharedPreferences("a1",GotowaDieta.this,sniadanie1); // odebranie slowa za pomoca klucza, i wypisanie go na polu tekstowym
            Dieta.setSharedPreferences("a2",GotowaDieta.this,sniadaniedrugie1);
            Dieta.setSharedPreferences("a3",GotowaDieta.this,obiad1);
            Dieta.setSharedPreferences("a4",GotowaDieta.this,podwieczorek1);
            Dieta.setSharedPreferences("a5",GotowaDieta.this,kolacja1);

        }
        else if(Dieta.zaznaczonyindex==1){

            Dieta.setSharedPreferences("a6",GotowaDieta.this,sniadanie1);
            Dieta.setSharedPreferences("a7",GotowaDieta.this,sniadaniedrugie1);
            Dieta.setSharedPreferences("a8",GotowaDieta.this,obiad1);
            Dieta.setSharedPreferences("a9",GotowaDieta.this,podwieczorek1);
            Dieta.setSharedPreferences("a10",GotowaDieta.this,kolacja1);

        }

        else if(Dieta.zaznaczonyindex==2){

            Dieta.setSharedPreferences("a11",GotowaDieta.this,sniadanie1);
            Dieta.setSharedPreferences("a12",GotowaDieta.this,sniadaniedrugie1);
            Dieta.setSharedPreferences("a13",GotowaDieta.this,obiad1);
            Dieta.setSharedPreferences("a14",GotowaDieta.this,podwieczorek1);
            Dieta.setSharedPreferences("a15",GotowaDieta.this,kolacja1);

        }

        else {

            Dieta.setSharedPreferences("a16",GotowaDieta.this,sniadanie1);
            Dieta.setSharedPreferences("a17",GotowaDieta.this,sniadaniedrugie1);
            Dieta.setSharedPreferences("a18",GotowaDieta.this,obiad1);
            Dieta.setSharedPreferences("a19",GotowaDieta.this,podwieczorek1);
            Dieta.setSharedPreferences("a20",GotowaDieta.this,kolacja1);

        }




    }



    private void ustalDieteWt(){
        if(Dieta.zaznaczonyindex==0){

            Dieta.setSharedPreferences("b1",GotowaDieta.this,sniadanie2);
            Dieta.setSharedPreferences("b2",GotowaDieta.this,sniadaniedrugie2);
            Dieta.setSharedPreferences("b3",GotowaDieta.this,obiad2);
            Dieta.setSharedPreferences("b4",GotowaDieta.this,podwieczorek2);
            Dieta.setSharedPreferences("b5",GotowaDieta.this,kolacja2);

        }
        else if(Dieta.zaznaczonyindex==1){

            Dieta.setSharedPreferences("b6",GotowaDieta.this,sniadanie2);
            Dieta.setSharedPreferences("b7",GotowaDieta.this,sniadaniedrugie2);
            Dieta.setSharedPreferences("b8",GotowaDieta.this,obiad2);
            Dieta.setSharedPreferences("b9",GotowaDieta.this,podwieczorek2);
            Dieta.setSharedPreferences("b10",GotowaDieta.this,kolacja2);

        }

        else if(Dieta.zaznaczonyindex==2){

            Dieta.setSharedPreferences("b11",GotowaDieta.this,sniadanie2);
            Dieta.setSharedPreferences("b12",GotowaDieta.this,sniadaniedrugie2);
            Dieta.setSharedPreferences("b13",GotowaDieta.this,obiad2);
            Dieta.setSharedPreferences("b14",GotowaDieta.this,podwieczorek2);
            Dieta.setSharedPreferences("b15",GotowaDieta.this,kolacja2);

        }

        else {

            Dieta.setSharedPreferences("b16",GotowaDieta.this,sniadanie2);
            Dieta.setSharedPreferences("b17",GotowaDieta.this,sniadaniedrugie2);
            Dieta.setSharedPreferences("b18",GotowaDieta.this,obiad2);
            Dieta.setSharedPreferences("b19",GotowaDieta.this,podwieczorek2);
            Dieta.setSharedPreferences("b20",GotowaDieta.this,kolacja2);

        }




    }

    private void ustalDieteSr(){
        if(Dieta.zaznaczonyindex==0){

            Dieta.setSharedPreferences("c1",GotowaDieta.this,sniadanie3);
            Dieta.setSharedPreferences("c2",GotowaDieta.this,sniadaniedrugie3);
            Dieta.setSharedPreferences("c3",GotowaDieta.this,obiad3);
            Dieta.setSharedPreferences("c4",GotowaDieta.this,podwieczorek3);
            Dieta.setSharedPreferences("c5",GotowaDieta.this,kolacja3);

        }
        else if(Dieta.zaznaczonyindex==1){

            Dieta.setSharedPreferences("c6",GotowaDieta.this,sniadanie3);
            Dieta.setSharedPreferences("c7",GotowaDieta.this,sniadaniedrugie3);
            Dieta.setSharedPreferences("c8",GotowaDieta.this,obiad3);
            Dieta.setSharedPreferences("c9",GotowaDieta.this,podwieczorek3);
            Dieta.setSharedPreferences("c10",GotowaDieta.this,kolacja3);

        }

        else if(Dieta.zaznaczonyindex==2){

            Dieta.setSharedPreferences("c11",GotowaDieta.this,sniadanie3);
            Dieta.setSharedPreferences("c12",GotowaDieta.this,sniadaniedrugie3);
            Dieta.setSharedPreferences("c13",GotowaDieta.this,obiad3);
            Dieta.setSharedPreferences("c14",GotowaDieta.this,podwieczorek3);
            Dieta.setSharedPreferences("c15",GotowaDieta.this,kolacja3);

        }

        else {

            Dieta.setSharedPreferences("c16",GotowaDieta.this,sniadanie3);
            Dieta.setSharedPreferences("c17",GotowaDieta.this,sniadaniedrugie3);
            Dieta.setSharedPreferences("c18",GotowaDieta.this,obiad3);
            Dieta.setSharedPreferences("c19",GotowaDieta.this,podwieczorek3);
            Dieta.setSharedPreferences("c20",GotowaDieta.this,kolacja3);

        }




    }

    private void ustalDieteCz(){
        if(Dieta.zaznaczonyindex==0){

            Dieta.setSharedPreferences("d1",GotowaDieta.this,sniadanie4);
            Dieta.setSharedPreferences("d2",GotowaDieta.this,sniadaniedrugie4);
            Dieta.setSharedPreferences("d3",GotowaDieta.this,obiad4);
            Dieta.setSharedPreferences("d4",GotowaDieta.this,podwieczorek4);
            Dieta.setSharedPreferences("d5",GotowaDieta.this,kolacja4);

        }
        else if(Dieta.zaznaczonyindex==1){

            Dieta.setSharedPreferences("d6",GotowaDieta.this,sniadanie4);
            Dieta.setSharedPreferences("d7",GotowaDieta.this,sniadaniedrugie4);
            Dieta.setSharedPreferences("d8",GotowaDieta.this,obiad4);
            Dieta.setSharedPreferences("d9",GotowaDieta.this,podwieczorek4);
            Dieta.setSharedPreferences("d10",GotowaDieta.this,kolacja4);

        }

        else if(Dieta.zaznaczonyindex==2){

            Dieta.setSharedPreferences("d11",GotowaDieta.this,sniadanie4);
            Dieta.setSharedPreferences("d12",GotowaDieta.this,sniadaniedrugie4);
            Dieta.setSharedPreferences("d13",GotowaDieta.this,obiad4);
            Dieta.setSharedPreferences("d14",GotowaDieta.this,podwieczorek4);
            Dieta.setSharedPreferences("d15",GotowaDieta.this,kolacja4);

        }

        else {

            Dieta.setSharedPreferences("d16",GotowaDieta.this,sniadanie4);
            Dieta.setSharedPreferences("d17",GotowaDieta.this,sniadaniedrugie4);
            Dieta.setSharedPreferences("d18",GotowaDieta.this,obiad4);
            Dieta.setSharedPreferences("d19",GotowaDieta.this,podwieczorek4);
            Dieta.setSharedPreferences("d20",GotowaDieta.this,kolacja4);

        }




    }

    private void ustalDietePt(){
        if(Dieta.zaznaczonyindex==0){

            Dieta.setSharedPreferences("e1",GotowaDieta.this,sniadanie5);
            Dieta.setSharedPreferences("e2",GotowaDieta.this,sniadaniedrugie5);
            Dieta.setSharedPreferences("e3",GotowaDieta.this,obiad5);
            Dieta.setSharedPreferences("e4",GotowaDieta.this,podwieczorek5);
            Dieta.setSharedPreferences("e5",GotowaDieta.this,kolacja5);

        }
        else if(Dieta.zaznaczonyindex==1){

            Dieta.setSharedPreferences("e6",GotowaDieta.this,sniadanie5);
            Dieta.setSharedPreferences("e7",GotowaDieta.this,sniadaniedrugie5);
            Dieta.setSharedPreferences("e8",GotowaDieta.this,obiad5);
            Dieta.setSharedPreferences("e9",GotowaDieta.this,podwieczorek5);
            Dieta.setSharedPreferences("e10",GotowaDieta.this,kolacja5);

        }

        else if(Dieta.zaznaczonyindex==2){

            Dieta.setSharedPreferences("e11",GotowaDieta.this,sniadanie5);
            Dieta.setSharedPreferences("e12",GotowaDieta.this,sniadaniedrugie5);
            Dieta.setSharedPreferences("e13",GotowaDieta.this,obiad5);
            Dieta.setSharedPreferences("e14",GotowaDieta.this,podwieczorek5);
            Dieta.setSharedPreferences("e15",GotowaDieta.this,kolacja5);

        }

        else {

            Dieta.setSharedPreferences("e16",GotowaDieta.this,sniadanie5);
            Dieta.setSharedPreferences("e17",GotowaDieta.this,sniadaniedrugie5);
            Dieta.setSharedPreferences("e18",GotowaDieta.this,obiad5);
            Dieta.setSharedPreferences("e19",GotowaDieta.this,podwieczorek5);
            Dieta.setSharedPreferences("e20",GotowaDieta.this,kolacja5);

        }




    }


    private void drukuj(){ //metoda drukujaca bitmape do jpg


        Bitmap bitmap = pobierzBitmapezWidoku(scrollview,scrollview.getChildAt(0).getHeight(),scrollview.getChildAt(0).getWidth());
        try {
            File defaultFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Dieta"); //tworzymy folder na sd karcie
            if (!defaultFile.exists()) //jezeli nie istnieje to stworz folder
                defaultFile.mkdirs();

            String filename = "dieta " + ".jpg"; //tak nazywac bedzie sie nasz plik
            File file = new File(defaultFile,filename); //tworzymy nowy plik  w folderze plantrening o nazwie plantreningowy
            if (file.exists()) { //jezeli plik istnieje to podmieniamy go na nowy
                file.delete();
                file = new File(defaultFile,filename);
            }

            FileOutputStream output = new FileOutputStream(file); //tworzenia strumienia wyjsciowego dla pliku okreslonego w obiekcie File
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, output); // kompresja bitmapy do formatu png z jakoscią 100 i przekazanie do bufora wyjsciowego
            output.flush(); // oproznienie bufora wyjsciowego umozliwiajac zapis wszystkich zbuforowanych bajtów/znakow do ich miejsca przeznaczenia, w tym wypadku umozliwia zapis danych z widoku do pliku
            output.close(); // Plik zapisany, nastepuje zamkniecie bufora wyjsciowego bez mozliwosci ponownego otworzenia

            Uri uri =Uri.fromFile(file); // przechowanie sciezki do pliku
            Intent intencja = new Intent(Intent.ACTION_VIEW);
            intencja.setDataAndType(uri,"image/*");
            startActivity(intencja);
            Toast.makeText(this, "Twoja dieta została zapisana!", Toast.LENGTH_SHORT).show();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Bitmap pobierzBitmapezWidoku(View view,int height,int width) { // metoda która tworzy obraz z widoku w tym wypadku ze scrollview naszego xmla

        Bitmap bitmap = Bitmap.createBitmap(width, height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap); // klasa Canvas przetrzymuje odwolania do "narysowania" czegos w tym wypadku bitmapy z widoku scrollview
        Drawable bgDrawable =view.getBackground(); // pobieramy tlo widoku xmla
        if (bgDrawable!=null) // widok nie jest nullem, to narysuj cos i przechowaj w kanwie
            bgDrawable.draw(canvas);
        else
            canvas.drawColor(Color.WHITE);
        view.draw(canvas);
        return bitmap;
    }


    public void onBackPressed() { // metoda ktora po kliknieciu przycisku cofnij wyswietlania komunikat o ostrzezeniu
        AlertDialog.Builder alertdialog=new AlertDialog.Builder(this);
        alertdialog.setTitle("Ostrzeżenie");
        alertdialog.setMessage("Jeżeli nie zapisałeś swojej  diety, po wyjściu utracisz wszystkie dane na jej temat. Na pewno chcesz wyjść ? ");
        alertdialog.setPositiveButton("Tak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                GotowaDieta.super.onBackPressed(); // wywolanie tej metody ...

            }
        });

        alertdialog.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        alertdialog.create();
        alertdialog.show();
    }


    private void ustalGodzinyPosilkow (){ // odebranie i ustawienie w poszczegolnych polach textview poszczegolnych posilkow wylosowanych w Dieta.java

        if(Dieta.zaznaczonyindex2 ==0){

            Dieta.setSharedPreferences("s22a",GotowaDieta.this,godzinasniadanie);
            Dieta.setSharedPreferences("s22b",GotowaDieta.this,godzinasniadaniedrugie);
            Dieta.setSharedPreferences("s22c",GotowaDieta.this,godzinaobiad);
            Dieta.setSharedPreferences("s22d",GotowaDieta.this,godzinapodwieczorek);
            Dieta.setSharedPreferences("s22e",GotowaDieta.this,godzinakolacja);

            Dieta.setSharedPreferences("s22f",GotowaDieta.this,godzinasniadanie2);
            Dieta.setSharedPreferences("s22g",GotowaDieta.this,godzinasniadaniedrugie2);
            Dieta.setSharedPreferences("s22h",GotowaDieta.this,godzinaobiad2);
            Dieta.setSharedPreferences("s22i",GotowaDieta.this,godzinapodwieczorek2);
            Dieta.setSharedPreferences("s22j",GotowaDieta.this,godzinakolacja2);

            Dieta.setSharedPreferences("s22k",GotowaDieta.this,godzinasniadanie3);
            Dieta.setSharedPreferences("s22l",GotowaDieta.this,godzinasniadaniedrugie3);
            Dieta.setSharedPreferences("s22m",GotowaDieta.this,godzinaobiad3);
            Dieta.setSharedPreferences("s22n",GotowaDieta.this,godzinapodwieczorek3);
            Dieta.setSharedPreferences("s22o",GotowaDieta.this,godzinakolacja3);

            Dieta.setSharedPreferences("s22p",GotowaDieta.this,godzinasniadanie4);
            Dieta.setSharedPreferences("s22r",GotowaDieta.this,godzinasniadaniedrugie4);
            Dieta.setSharedPreferences("s22s",GotowaDieta.this,godzinaobiad4);
            Dieta.setSharedPreferences("s22t",GotowaDieta.this,godzinapodwieczorek4);
            Dieta.setSharedPreferences("s22u",GotowaDieta.this,godzinakolacja4);

            Dieta.setSharedPreferences("s22w",GotowaDieta.this,godzinasniadanie5);
            Dieta.setSharedPreferences("s22x",GotowaDieta.this,godzinasniadaniedrugie5);
            Dieta.setSharedPreferences("s22y",GotowaDieta.this,godzinaobiad5);
            Dieta.setSharedPreferences("s22z",GotowaDieta.this,godzinapodwieczorek5);
            Dieta.setSharedPreferences("s22zz",GotowaDieta.this,godzinakolacja5);

        }

        else if(Dieta.zaznaczonyindex2 ==1){

            Dieta.setSharedPreferences("s23a",GotowaDieta.this,godzinasniadanie);
            Dieta.setSharedPreferences("s23b",GotowaDieta.this,godzinasniadaniedrugie);
            Dieta.setSharedPreferences("s23c",GotowaDieta.this,godzinaobiad);
            Dieta.setSharedPreferences("s23d",GotowaDieta.this,godzinapodwieczorek);
            Dieta.setSharedPreferences("s23e",GotowaDieta.this,godzinakolacja);

            Dieta.setSharedPreferences("s23f",GotowaDieta.this,godzinasniadanie2);
            Dieta.setSharedPreferences("s23g",GotowaDieta.this,godzinasniadaniedrugie2);
            Dieta.setSharedPreferences("s23h",GotowaDieta.this,godzinaobiad2);
            Dieta.setSharedPreferences("s23i",GotowaDieta.this,godzinapodwieczorek2);
            Dieta.setSharedPreferences("s23j",GotowaDieta.this,godzinakolacja2);

            Dieta.setSharedPreferences("s23k",GotowaDieta.this,godzinasniadanie3);
            Dieta.setSharedPreferences("s23l",GotowaDieta.this,godzinasniadaniedrugie3);
            Dieta.setSharedPreferences("s23m",GotowaDieta.this,godzinaobiad3);
            Dieta.setSharedPreferences("s23n",GotowaDieta.this,godzinapodwieczorek3);
            Dieta.setSharedPreferences("s23o",GotowaDieta.this,godzinakolacja3);

            Dieta.setSharedPreferences("s23p",GotowaDieta.this,godzinasniadanie4);
            Dieta.setSharedPreferences("s23r",GotowaDieta.this,godzinasniadaniedrugie4);
            Dieta.setSharedPreferences("s23s",GotowaDieta.this,godzinaobiad4);
            Dieta.setSharedPreferences("s23t",GotowaDieta.this,godzinapodwieczorek4);
            Dieta.setSharedPreferences("s23u",GotowaDieta.this,godzinakolacja4);

            Dieta.setSharedPreferences("s23w",GotowaDieta.this,godzinasniadanie5);
            Dieta.setSharedPreferences("s23x",GotowaDieta.this,godzinasniadaniedrugie5);
            Dieta.setSharedPreferences("s23y",GotowaDieta.this,godzinaobiad5);
            Dieta.setSharedPreferences("s23z",GotowaDieta.this,godzinapodwieczorek5);
            Dieta.setSharedPreferences("s23zz",GotowaDieta.this,godzinakolacja5);

        }

        else{

            Dieta.setSharedPreferences("s24a",GotowaDieta.this,godzinasniadanie);
            Dieta.setSharedPreferences("s24b",GotowaDieta.this,godzinasniadaniedrugie);
            Dieta.setSharedPreferences("s24c",GotowaDieta.this,godzinaobiad);
            Dieta.setSharedPreferences("s24d",GotowaDieta.this,godzinapodwieczorek);
            Dieta.setSharedPreferences("s24e",GotowaDieta.this,godzinakolacja);

            Dieta.setSharedPreferences("s24f",GotowaDieta.this,godzinasniadanie2);
            Dieta.setSharedPreferences("s24g",GotowaDieta.this,godzinasniadaniedrugie2);
            Dieta.setSharedPreferences("s24h",GotowaDieta.this,godzinaobiad2);
            Dieta.setSharedPreferences("s24i",GotowaDieta.this,godzinapodwieczorek2);
            Dieta.setSharedPreferences("s24j",GotowaDieta.this,godzinakolacja2);

            Dieta.setSharedPreferences("s24k",GotowaDieta.this,godzinasniadanie3);
            Dieta.setSharedPreferences("s24l",GotowaDieta.this,godzinasniadaniedrugie3);
            Dieta.setSharedPreferences("s24m",GotowaDieta.this,godzinaobiad3);
            Dieta.setSharedPreferences("s24n",GotowaDieta.this,godzinapodwieczorek3);
            Dieta.setSharedPreferences("s24o",GotowaDieta.this,godzinakolacja3);

            Dieta.setSharedPreferences("s24p",GotowaDieta.this,godzinasniadanie4);
            Dieta.setSharedPreferences("s24r",GotowaDieta.this,godzinasniadaniedrugie4);
            Dieta.setSharedPreferences("s24s",GotowaDieta.this,godzinaobiad4);
            Dieta.setSharedPreferences("s24t",GotowaDieta.this,godzinapodwieczorek4);
            Dieta.setSharedPreferences("s24u",GotowaDieta.this,godzinakolacja4);

            Dieta.setSharedPreferences("s24w",GotowaDieta.this,godzinasniadanie5);
            Dieta.setSharedPreferences("s24x",GotowaDieta.this,godzinasniadaniedrugie5);
            Dieta.setSharedPreferences("s24y",GotowaDieta.this,godzinaobiad5);
            Dieta.setSharedPreferences("s24z",GotowaDieta.this,godzinapodwieczorek5);
            Dieta.setSharedPreferences("s24zz",GotowaDieta.this,godzinakolacja5);

        }
    }

}
