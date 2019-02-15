package com.example.luke.trener;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

class CustomAdapter extends ArrayAdapter<String> { // aby ustworzyc własny adapter nalezy rozszerzyc klase array adapter ( podstawowa klase javy)

    private final int[] zdjecia; // utworzenie zmiennej tablicowej zdjecia, tablice ta nalezy umiescic w konstruktorze naszego adaptera



    public CustomAdapter(Context context, String[] cwiczenia1, int[] zdjecia){ //  aby utworzyc wlasny adapter, konieczne jest stworzenie konstruktora tego typu, pierwszym z parametrów jest kontekst, czyli bieżący stan aplikacji
                                                                                // następnie musimy podać źródła naszych tablic w tym przypadku ćwiczeń oraz zdjęć

        super(context, R.layout.custom_row , cwiczenia1); // do konstruktora klasy bazowej należy podać 3 argumenty, pierwszym z nich jest kontekst, drugim wygląd naszego spersonalizowanego layoutu z którego
                                                            // będzie korzystał nasz adapter a trzecim nasza tablica ćwiczeń ( należy przekazac tutaj tablice tylko typu String)
        this.zdjecia = zdjecia;                              // dlatego tablica zdjęć która jest typu Int musi zostać przekazana w ten sposób.

    }



    @Override
    public View getView(int position,  View convertView, ViewGroup parent) { // metoda getView umożliwa wyświetlenie na naszym domyślnym layoucie elementów którze przekazaliśmy w naszym custom adapterze w tym przypadku
                                                                                // umożliwia wyświetlenie stringów tablicy ćwiczeń i zdjęć tablic zdjecia
        LayoutInflater inflater = LayoutInflater.from(getContext()); // proces łączenia widoku naszego layoutu z aktywnością kodem javy
        View customView = convertView;
        if(customView == null){
            customView = inflater.inflate(R.layout.custom_row, parent, false); // w zmiennej custom view przekazujemy do naszej podstawowej listy, poszczególny wiersz z naszej spersonalizowanej listy
                                                                                                                //  tzn nasz wiersz będzie wyświetlany na podsawie widgetu ListView android czyli na podstawwie domyslenj listy
        }

        String pojedynczyElementTablicy = getItem(position);  // w zmiennej pojedynczyElement pobieramy każdy z poszczególnych indeksów naszej tablicy ćwiczeń do wyświetlenia na podstawowej liscie
        TextView tv = (TextView) customView.findViewById(R.id.textView); // pobieramy referencje do naszego TextView  w custom_row

        ImageView foto = (ImageView) customView.findViewById(R.id.imageView); // referencja do zdjęcia

        tv.setText(pojedynczyElementTablicy); // mając już adres naszego Text View, wypełniamy go poszczególnymi elementami z tablicy cwiczenia
        foto.setImageResource(zdjecia[position]); // to samo tylko z tablica zdjecia.


        return customView; // zwracamy widok naszego adaptera i wyswietlamy.





    }
}
