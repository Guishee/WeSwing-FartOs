package com.example.fartos.RecyclerCartas;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fartos.R;


public class CartaViewManager extends RecyclerView.ViewHolder {

    private TextView carta;
    CartaViewManager(@NonNull View itemView) {
        super(itemView);
        carta = itemView.findViewById(R.id.carta);
    }

    public TextView getCarta() {return carta;}
}


