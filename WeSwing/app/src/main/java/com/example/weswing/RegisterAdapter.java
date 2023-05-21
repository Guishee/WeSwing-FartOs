package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RegisterAdapter extends RecyclerView.Adapter<RegisterAdapter.ViewHolder> {

    private String[] fieldNames = {"Nombre", "Apellido", "Correo", "Contraseña", "Repetir Contraseña",
            "Idioma", "Ciudad", "Bailarín o Profesor"};

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_register_field, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String fieldName = fieldNames[position];
        holder.bind(fieldName);
    }

    @Override
    public int getItemCount() {
        return fieldNames.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private EditText editText;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editText = itemView.findViewById(R.id.editText);

        }

        public void bind(String fieldName) {
            editText.setHint(fieldName);
        }
    }
}
