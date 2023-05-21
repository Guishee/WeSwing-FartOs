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

public class MogudaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MogudaAdapter adapter;
    private List<CardViewItem> items;
    private Button verAsistentes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moguda);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        items = new ArrayList<>();
        items.add(new TitleCardViewItem("Título del evento"));
        items.add(new ToggleButtonCardViewItem());
        items.add(new OrganizerCardViewItem(R.drawable.profilecinco, "Nombre del organizador"));
        items.add(new DescriptionCardViewItem("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at ullamcorper urna. Phasellus mauris arcu, tincidunt quis imperdiet vitae, dapibus vel dolor. Maecenas pharetra, libero sed fermentum tempus, urna sem accumsan nisi, eget porttitor mi est vel enim. Phasellus molestie."));
        items.add(new AttendeesCardViewItem("Número de asistentes: 100    "));
        items.add(new ImagesCardViewItem("No hay imágenes"));


        adapter = new MogudaAdapter(items);
        recyclerView.setAdapter(adapter);

        verAsistentes=findViewById(R.id.toAsistentes);
        verAsistentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MogudaActivity.this,AsistentesActivity.class);
                startActivity(intent);
            }
        });
    }
}
