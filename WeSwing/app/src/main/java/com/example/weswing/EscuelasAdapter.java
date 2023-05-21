package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EscuelasAdapter extends RecyclerView.Adapter<EscuelasAdapter.EscuelaViewHolder> {

    private List<Escuela> escuelas;

    public EscuelasAdapter(List<Escuela> escuelas) {
        this.escuelas = escuelas;
    }

    @NonNull
    @Override
    public EscuelaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_escuela, parent, false);
        return new EscuelaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EscuelaViewHolder holder, int position) {
        Escuela escuela = escuelas.get(position);


        holder.imagenPerfilImageView.setImageResource(R.drawable.profilecinco);
        holder.nombreEscuelaTextView.setText(escuela.getNombre());
        holder.subtituloTextView.setText(escuela.getSubtitulo());
        holder.boton.setText("Botón");
        holder.toggleButton.setText("ToggleButton");
        holder.tituloTextView.setText("Descripción");
        holder.descripcionTextView.setText(escuela.getDescripcion());
        holder.textoTextView.setText(escuela.getTexto());
    }

    @Override
    public int getItemCount() {
        return escuelas.size();
    }

    public static class EscuelaViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagenPerfilImageView;
        public TextView nombreEscuelaTextView;
        public TextView subtituloTextView;
        public Button boton;
        public ToggleButton toggleButton;
        public TextView tituloTextView;
        public TextView descripcionTextView;
        public TextView textoTextView;

        public EscuelaViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenPerfilImageView = itemView.findViewById(R.id.imagenPerfilImageView);
            nombreEscuelaTextView = itemView.findViewById(R.id.nombreEscuelaTextView);
            subtituloTextView = itemView.findViewById(R.id.subtituloTextView);
            boton = itemView.findViewById(R.id.boton);
            toggleButton = itemView.findViewById(R.id.toggleButton);
            tituloTextView = itemView.findViewById(R.id.tituloTextView);
            descripcionTextView = itemView.findViewById(R.id.descripcionTextView);
            textoTextView = itemView.findViewById(R.id.seguiTextView);
        }
    }
}

