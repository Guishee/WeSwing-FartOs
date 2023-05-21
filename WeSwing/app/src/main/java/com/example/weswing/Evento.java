package com.example.weswing;

public class Evento {
    private String textoNegrita;
    private String fechaHora;
    private int logoResId;

    public Evento(String textoNegrita, String fechaHora, int logoResId) {
        this.textoNegrita = textoNegrita;
        this.fechaHora = fechaHora;
        this.logoResId = logoResId;
    }

    public String getTextoNegrita() {
        return textoNegrita;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public int getLogoResId() {
        return logoResId;
    }
}
