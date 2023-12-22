package com.example.codigocc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import com.example.codigocc.databinding.ActivityPersonaBinding;

import java.util.ArrayList;

public class PersonaActivity extends AppCompatActivity {
    ActivityPersonaBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPersonaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = this.getIntent();
        if (intent != null){

            // VARIABLES OBTENIDAS DE INTENT...

            String name = intent.getStringExtra("name");
            String gender = intent.getStringExtra("gender");
            String age = intent.getStringExtra("age");
            int desc = intent.getIntExtra("desc", R.string.OS);
            int image = intent.getIntExtra("image", R.drawable.os);
            int position = intent.getIntExtra("position", -1);

            ArrayList<String> NameList = intent.getStringArrayListExtra("nameList");

            binding.PersonaName.setText(name);
            binding.PersonaGender.setText(gender);
            binding.PersonaAge.setText(age);
            binding.PersonaDesc.setText(desc);
            binding.PersonaImage.setImageResource(image);

            // BOTON DE ELIMINAR....

            Button btnDelete;
            btnDelete = (Button) findViewById(R.id.btnDelete);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    if (position != -1) {

                        Intent resultIntent = new Intent();
                        resultIntent.putExtra("deletedPosition", position);
                        setResult(RESULT_OK, resultIntent);

                    }

                    Toast Confirmed = Toast.makeText(getApplicationContext(), "Artista Eliminado", Toast.LENGTH_SHORT);

                    Confirmed.show();

                    finish();
                }
            });
        }
    }
}