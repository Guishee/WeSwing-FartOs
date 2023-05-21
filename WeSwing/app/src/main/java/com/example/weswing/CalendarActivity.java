package com.example.weswing;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CalendarActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CalendarAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        adapter = new CalendarAdapter(getEventos());
        recyclerView.setAdapter(adapter);
    }


    private List<Evento> getEventos() {
        List<Evento> eventos = new ArrayList<>();

        eventos.add(new Evento("Evento 1", "10 de mayo, 8:00 AM", R.drawable.danceuno));
        eventos.add(new Evento("Evento 2", "15 de mayo, 3:30 PM", R.drawable.dancedos));
        eventos.add(new Evento("Evento 3", "15 de abril, 3:00 PM", R.drawable.dancetres));
        eventos.add(new Evento("Evento 3", "05 de junio, 7:00 PM", R.drawable.dancecuatro));
        eventos.add(new Evento("Evento 3", "02 de agosto, 1:00 PM", R.drawable.dancecinco));
        eventos.add(new Evento("Evento 3", "25 de septiembre, 5:00 PM", R.drawable.danceceis));


        return eventos;
    }
}
