package com.example.weswing;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PerfilPersonaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PerfilPersonaAdapter adapter;
    private Button toEscuela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil_persona);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new PerfilPersonaAdapter(getPersonas());
        recyclerView.setAdapter(adapter);

        toEscuela=findViewById(R.id.toEscuelas);
        toEscuela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(PerfilPersonaActivity.this,EscuelasActivity.class);
                startActivity(intent);
            }
        });
    }


    private List<Persona> getPersonas() {
        List<Persona> personas = new ArrayList<>();

        personas.add(new Persona("Nombre Persona 1"));
        personas.add(new Persona("Nombre Persona 2"));
        personas.add(new Persona("Nombre Persona 3"));


        return personas;
    }
}
