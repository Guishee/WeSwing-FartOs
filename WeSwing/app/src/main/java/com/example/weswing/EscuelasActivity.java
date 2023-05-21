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

public class EscuelasActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EscuelasAdapter adapter;
    private Button toProfes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escuelas);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new EscuelasAdapter(getEscuelas());
        recyclerView.setAdapter(adapter);

        toProfes=findViewById(R.id.toProfes);
        toProfes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(EscuelasActivity.this,ProfesActivity.class);
                startActivity(intent);
            }
        });
    }


    private List<Escuela> getEscuelas() {
        List<Escuela> escuelas = new ArrayList<>();

        escuelas.add(new Escuela("Escuela 1", "85 alumnos - Tarragona", "Descripción de la escuela 1", "Numero de Seguidores: 20"));
        escuelas.add(new Escuela("Escuela 2", "90 alumnos - Barcelona", "Descripción de la escuela 2", "Numero de Seguidores: 10"));
        escuelas.add(new Escuela("Escuela 3", "30 alumnos - Madrid", "Descripción de la escuela 3", "Numero de Seguidores: 5"));


        return escuelas;
    }
}
