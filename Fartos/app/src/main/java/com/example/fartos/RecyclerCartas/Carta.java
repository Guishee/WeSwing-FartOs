package com.example.fartos.RecyclerCartas;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Carta implements Parcelable {

    public enum tipuscarta {
        MOV_1(28), MOV_2(18), MOV_3(10),
        TELEPORT(3), ZANCADILLA(4), PATADA(3),
        HUNDIMIENTO(2), BROMA(2);

        private int numCartes;
        public int getNumCartes() { return numCartes; }

        tipuscarta(int numCartes) {
            this.numCartes = numCartes;
        }
    }


    private int numero;
    private tipuscarta efecte;


    public int getNumero() {
        return numero;
    }
    public tipuscarta getEfecte() {
        return efecte;
    }


    public Carta(int numero, tipuscarta efecte) {
        this.numero = numero;
        this.efecte = efecte;
    }




    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();


        result.append(numero + " --> ");
        switch (efecte) {
            case MOV_1:
                result.append("Mover 1");
                break;

            case MOV_2:
                result.append("Mover 2");
                break;

            case MOV_3:
                result.append("Mover 3");
                break;

            default:
                result.append(efecte.name() + "");
        }

        return result.toString();
    }


    public static List<Carta> generarBaralla() {
        List<Carta> result = new ArrayList<>();
        int numeroCarta = 1;

        // Crea las cartes
        for (tipuscarta tipuscarta : tipuscarta.values()) {
            for (int i = 0; i < tipuscarta.getNumCartes(); i++)
                result.add(new Carta(numeroCarta++, tipuscarta));
        }

        // Reordena las cartes
        Collections.shuffle(result);

        return result;
    }

    protected Carta(Parcel in) {
        // Read the Carta object properties from the Parcel
    }

    public static final Creator<Carta> CREATOR = new Creator<Carta>() {
        @Override
        public Carta createFromParcel(Parcel in) {
            return new Carta(in);
        }

        @Override
        public Carta[] newArray(int size) {
            return new Carta[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // Write the Carta object properties to the Parcel
    }
}

