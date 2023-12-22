package com.example.codigocc;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import com.example.codigocc.databinding.ActivityMainBinding;
import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PersonaAdapter listAdapter;
    ArrayList<Persona> dataArrayList = new ArrayList<>();
    Persona listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // CREACION DE PERSONAS...
        
        int[] ImageList = {R.drawable.os, R.drawable.kq, R.drawable.be, R.drawable.cl, R.drawable.jh, R.drawable.nc};
        String[] AgeList = {"Edad: 36","Edad: 36","Edad: 21","Edad: 34","Edad: 22","Edad: 22"};

        // AQUI ESTAN LOS STRINGS ANTES MENCIONADOS EN PERSONA...
        int[] DescList = {R.string.OS, R.string.KQ, R.string.BE,R.string.CL,R.string.JH, R.string.NC};

        String[] NameList = {"Oliver Sykes","Kellin Quinn","Billie Eilish","Courtney LaPlane","Junior H","Natanael Cano"};
        String[] GenderList = {"Masculino", "Masculino","Femenino","Femenino", "Masculino","Masculino"};

        for (int i = 0; i < ImageList.length; i++){
            listData = new Persona(NameList[i], GenderList[i], DescList[i], AgeList[i], ImageList[i]);
            dataArrayList.add(listData);
        }

        // ADAPTER DE LA LISTA...

        listAdapter = new PersonaAdapter(MainActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);

        // ENVIAR DATOS AL HACER CLIC EN ITEM...

        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, PersonaActivity.class);

                // SE ENVIAN LOS DATOS EN LA POSICION i ...

                intent.putExtra("name", NameList[i]);
                intent.putExtra("gender", GenderList[i]);
                intent.putExtra("age", AgeList[i]);
                intent.putExtra("desc", DescList[i]);
                intent.putExtra("image", ImageList[i]);
                intent.putExtra("position", i);

                intent.putExtra("nameList", NameList);

                // ESPERANDO RESULTADO DE PERSONA ACTIVITY...

                startActivityForResult(intent,i);
            }
        });
    }

    // FUNCION QUE RECIBE EL VALOR POSITION Y EJECUTA EL REMOVE_ITEM...

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode >= 0 && requestCode < dataArrayList.size()) {

            int deletedPosition = data.getIntExtra("deletedPosition", -1);

            if (deletedPosition != -1) {

                // SE ELIMINA Y SE NOTIFICA AL ADAPTER...
                dataArrayList.remove(deletedPosition);
                listAdapter.notifyDataSetChanged();
            }


        }
    }
}