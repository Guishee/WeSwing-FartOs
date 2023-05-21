package com.example.weswing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class AsistentesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AsistentesAdapter adapter;
    private List<Asistente> asistentes;
    private Button toPerfiles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asistentes);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        asistentes = new ArrayList<>();
        asistentes.add(new Asistente(R.drawable.profilecuatro, "Juan Pérez", "Profesor"));
        asistentes.add(new Asistente(R.drawable.profiledos, "María López", "Profesor"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Paco Saez", "Bailarin"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Roberto toto", "Bailarin"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Pedro Gimenez", "Profesor"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Mario Bros", "Bailarin"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Lechuga Pocha", "Profesor"));
        asistentes.add(new Asistente(R.drawable.profiledos, "Ayu Woki", "Profesor"));



        adapter = new AsistentesAdapter(asistentes);
        recyclerView.setAdapter(adapter);

        toPerfiles=findViewById(R.id.toPerfiles);
        toPerfiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AsistentesActivity.this,PerfilPersonaActivity.class);
                startActivity(intent);
            }
        });
    }
}
