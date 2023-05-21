package com.example.weswing;

public class Asistente {
    private int imagen;
    private String titulo;
    private String subtitulo;

    public Asistente(int imagen, String titulo, String subtitulo) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.subtitulo = subtitulo;
    }

    public int getImagen() {
        return imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getSubtitulo() {
        return subtitulo;
    }
}
