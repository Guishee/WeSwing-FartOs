package com.example.fartos;

import com.example.fartos.RecyclerCartas.Carta;

import java.util.ArrayList;
import java.util.List;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

public class Jugador implements Parcelable {

    private String nom;
    private List<Carta> ma;
    private boolean patada = false;
    private boolean zancadilla = false;

    private int position = 0;

    public String getNom() {
        return nom;
    }

    public List<Carta> getMa() {
        return ma;
    }

    public boolean isPatada() {
        return patada;
    }

    public boolean isZancadilla() {
        return zancadilla;
    }

    public void setMa(List<Carta> ma) {
        this.ma = new ArrayList<>();
        this.ma.addAll(ma);
    }

    public void removdeCarta(int num) {
        ma.remove(num);
    }

    public void setPatada(boolean patada) {
        this.patada = patada;
    }

    public void setZancadilla(boolean zancadilla) {
        this.zancadilla = zancadilla;
    }

    public Jugador(String nom) {
        this.nom = nom;
        this.ma = new ArrayList<>();
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return nom;
    }

    // Parcelable implementation
    protected Jugador(Parcel in) {
        nom = in.readString();
        ma = in.createTypedArrayList(Carta.CREATOR);
        patada = in.readByte() != 0;
        zancadilla = in.readByte() != 0;
        position = in.readInt();
    }

    public static final Creator<Jugador> CREATOR = new Creator<Jugador>() {
        @Override
        public Jugador createFromParcel(Parcel in) {
            return new Jugador(in);
        }

        @Override
        public Jugador[] newArray(int size) {
            return new Jugador[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nom);
        dest.writeTypedList(ma);
        dest.writeByte((byte) (patada ? 1 : 0));
        dest.writeByte((byte) (zancadilla ? 1 : 0));
        dest.writeInt(position);
    }
}
