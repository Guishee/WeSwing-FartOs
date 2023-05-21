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

public class ProfesActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProfesAdapter adapter;
    private Button toEventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profes);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new ProfesAdapter(getProfes());
        recyclerView.setAdapter(adapter);

        toEventos=findViewById(R.id.toCalendar);
        toEventos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ProfesActivity.this,CalendarActivity.class);
                startActivity(intent);
            }
        });
    }


    private List<Profe> getProfes() {
        List<Profe> profes = new ArrayList<>();

        profes.add(new Profe("Paco Lopez", R.drawable.profiletres));
        profes.add(new Profe("Isabella Parker", R.drawable.profilecinco));
        profes.add(new Profe("Oliver Evans", R.drawable.profileuno));
        profes.add(new Profe("Sophia Reed", R.drawable.profiledos));
        profes.add(new Profe("Mason Thompson", R.drawable.profiletres));
        profes.add(new Profe("Ava Collins", R.drawable.profilecinco));
        profes.add(new Profe("Liam Carter", R.drawable.profilecuatro));
        profes.add(new Profe("Mia Hughes", R.drawable.profileuno));
        profes.add(new Profe("Noah Adams", R.drawable.profilecinco));
        profes.add(new Profe("Harper Phillips", R.drawable.profiledos));



        return profes;
    }
}
