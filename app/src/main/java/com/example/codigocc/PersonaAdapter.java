package com.example.codigocc;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
public class PersonaAdapter extends ArrayAdapter<Persona> {
    public PersonaAdapter(@NonNull Context context, ArrayList<Persona> dataArrayList) {
        super(context, R.layout.list_persona, dataArrayList);
    }

    // FUNCION PARA ELIMINAR SEGUN LA POSICION...
    public void removeItem(int position) {
        if (position >= 0 && position < getCount()) {
            remove(getItem(position));

        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {

        // OBTENCION DE DATOS SEGUN LA POSICION...

        Persona listData = getItem(position);

        if (view == null){

            view = LayoutInflater.from(getContext()).inflate(R.layout.list_persona, parent, false);
        }

        ImageView listImage = view.findViewById(R.id.FavImage);
        TextView listName = view.findViewById(R.id.FavName);
        TextView listAge = view.findViewById(R.id.FavAge);

        listImage.setImageResource(listData.Image);
        listName.setText(listData.Name);
        listAge.setText(listData.Age);

        return view;
    }

    public void notifiyItemChanged() {


    }
}
