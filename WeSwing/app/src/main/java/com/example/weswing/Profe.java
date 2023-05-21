package com.example.weswing;

public class Profe {
    private String nombre;
    private int imagenResId;

    public Profe(String nombre, int imagenResId) {
        this.nombre = nombre;
        this.imagenResId = imagenResId;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagenResId() {
        return imagenResId;
    }
}
