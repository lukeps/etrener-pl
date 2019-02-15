package com.example.luke.trener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapterKlatkaPiersiowa extends ArrayAdapter<String> {

    public int[] zdjeciaklatka;




    public CustomAdapterKlatkaPiersiowa(Context context, String[] klatka, int[] zdjeciaklatka) {
        super(context, R.layout.custom_lista_cwiczen, klatka);

        this.zdjeciaklatka = zdjeciaklatka;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext()); // proces łączenia widoku naszego layoutu z aktywnością kodem javy
        View customView = convertView;
        if(customView == null){
            customView = inflater.inflate(R.layout.custom_lista_cwiczen, parent, false); // w zmiennej custom view przekazujemy do naszej podstawowej listy, poszczególny wiersz z naszej spersonalizowanej listy
            //  tzn nasz wiersz będzie wyświetlany na podsawie widgetu ListView android czyli na podstawwie domyslenj listy
        }

        String elementylistyklatka = getItem(position);

        ImageView referencjafoto = (ImageView) customView.findViewById(R.id.customfoto);

        TextView referencjatekst = (TextView) customView.findViewById(R.id.textView2);


        referencjafoto.setImageResource(zdjeciaklatka[position]);

        referencjatekst.setText(elementylistyklatka);

        return customView;


    }
}

