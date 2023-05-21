package com.example.weswing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.EventoViewHolder> {

    private List<Evento> eventos;

    public CalendarAdapter(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_calendar, parent, false);
        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        Evento evento = eventos.get(position);


        holder.logoImageView.setImageResource(evento.getLogoResId());
        holder.textoNegritaTextView.setText(evento.getTextoNegrita());
        holder.fechaHoraTextView.setText(evento.getFechaHora());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    public static class EventoViewHolder extends RecyclerView.ViewHolder {

        public ImageView logoImageView;
        public TextView textoNegritaTextView;
        public TextView fechaHoraTextView;

        public EventoViewHolder(@NonNull View itemView) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.logoImageView);
            textoNegritaTextView = itemView.findViewById(R.id.textoNegritaTextView);
            fechaHoraTextView = itemView.findViewById(R.id.fechaHoraTextView);
        }
    }
}
