package com.example.weswing;

public class Escuela {
    private String nombre;
    private String subtitulo;
    private String descripcion;
    private String texto;

    public Escuela(String nombre, String subtitulo, String descripcion, String texto) {
        this.nombre = nombre;
        this.subtitulo = subtitulo;
        this.descripcion = descripcion;
        this.texto = texto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSubtitulo() {
        return subtitulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getTexto() {
        return texto;
    }
}
