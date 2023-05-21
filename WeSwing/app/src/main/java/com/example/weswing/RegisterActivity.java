package com.example.weswing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterActivity extends AppCompatActivity {
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(new RegisterAdapter());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
        getSupportActionBar().setTitle("Título de la Actividad");

        b1=findViewById(R.id.completarRegistro);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(RegisterActivity.this,NewsFeedActivity.class);
                startActivity(intent);
            }
        });


    }
}
