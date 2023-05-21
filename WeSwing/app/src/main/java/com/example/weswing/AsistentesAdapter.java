package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AsistentesAdapter extends RecyclerView.Adapter<AsistentesAdapter.AsistenteViewHolder> {
    private List<Asistente> asistentes;

    public AsistentesAdapter(List<Asistente> asistentes) {
        this.asistentes = asistentes;
    }

    @NonNull
    @Override
    public AsistenteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_asistente, parent, false);
        return new AsistenteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AsistenteViewHolder holder, int position) {
        Asistente asistente = asistentes.get(position);
        holder.imageView.setImageResource(asistente.getImagen());
        holder.titleTextView.setText(asistente.getTitulo());
        holder.subtitleTextView.setText(asistente.getSubtitulo());
    }

    @Override
    public int getItemCount() {
        return asistentes.size();
    }

    public static class AsistenteViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titleTextView;
        TextView subtitleTextView;

        public AsistenteViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            subtitleTextView = itemView.findViewById(R.id.subtitleTextView);
        }
    }
}
