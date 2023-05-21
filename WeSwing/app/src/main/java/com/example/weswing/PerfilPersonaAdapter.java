package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PerfilPersonaAdapter extends RecyclerView.Adapter<PerfilPersonaAdapter.PerfilPersonaViewHolder> {

    private List<Persona> personas;

    public PerfilPersonaAdapter(List<Persona> personas) {
        this.personas = personas;
    }

    @NonNull
    @Override
    public PerfilPersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_perfil_persona, parent, false);
        return new PerfilPersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilPersonaViewHolder holder, int position) {
        Persona persona = personas.get(position);


        holder.nombreTextView.setText(persona.getNombre());
    }

    @Override
    public int getItemCount() {
        return personas.size();
    }

    public static class PerfilPersonaViewHolder extends RecyclerView.ViewHolder {

        public TextView nombreTextView;

        public PerfilPersonaViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreTextView = itemView.findViewById(R.id.nombreTextView);
        }
    }
}
