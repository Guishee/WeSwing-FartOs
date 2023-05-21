package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProfesAdapter extends RecyclerView.Adapter<ProfesAdapter.ProfeViewHolder> {

    private List<Profe> profes;

    public ProfesAdapter(List<Profe> profes) {
        this.profes = profes;
    }

    @NonNull
    @Override
    public ProfeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_profe, parent, false);
        return new ProfeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfeViewHolder holder, int position) {
        Profe profe = profes.get(position);


        holder.imagenProfeImageView.setImageResource(profe.getImagenResId());
        holder.nombreProfeTextView.setText(profe.getNombre());
    }

    @Override
    public int getItemCount() {
        return profes.size();
    }

    public static class ProfeViewHolder extends RecyclerView.ViewHolder {

        public ImageView imagenProfeImageView;
        public TextView nombreProfeTextView;

        public ProfeViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenProfeImageView = itemView.findViewById(R.id.imagenProfeImageView);
            nombreProfeTextView = itemView.findViewById(R.id.nombreProfeTextView);
        }
    }
}
