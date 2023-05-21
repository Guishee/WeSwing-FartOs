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

public class NewsFeedActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private NewsFeedAdapter adapter;
    private List<Notification> notifications;
    private Button moguda;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);


        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        notifications = new ArrayList<>();
        notifications.add(new Notification(R.drawable.profileuno, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));
        notifications.add(new Notification(R.drawable.profiledos, "Lorem ipsum dolor sit amet, consectetur."));
        notifications.add(new Notification(R.drawable.profiletres, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));
        notifications.add(new Notification(R.drawable.profilecuatro, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));
        notifications.add(new Notification(R.drawable.profilecinco, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));
        notifications.add(new Notification(R.drawable.profiledos, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));
        notifications.add(new Notification(R.drawable.profileuno, "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec varius."));



        adapter = new NewsFeedAdapter(notifications);
        recyclerView.setAdapter(adapter);

        moguda=findViewById(R.id.toMoguda);
        moguda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(NewsFeedActivity.this,MogudaActivity.class);
                startActivity(intent);
            }
        });
    }
}
