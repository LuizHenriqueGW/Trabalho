package com.example.entidades;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Abastecimento implements Serializable {
    private static int Litros=0;
    private int ID;

    public Integer getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public static int getLitros() {
        return Litros;
    }
    public static void adcLitros(int lits) {
        Litros = Litros + lits;
    }
    public static void rmvLitros(int lits){
        if(Litros-lits>=0){
            Litros=Litros-lits;
        }
    }

    @NonNull
    @Override
    public String toString() {
        return Litros+ '\'' +"Litros";
    }
}
