package com.example.entidades;

import java.io.Serializable;

public class info_Veiculo implements Serializable {
    private String Nome;
    private String Placa;
    private String Cor;
    private Integer ID;

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getPlaca() {
        return Placa;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    @Override
    public String toString() {
        return "Carro: " + '\'' + Nome + '\'' +
                ", Placa='" + Placa + '\'' +
                ", Cor='" + Cor + '\'';
    }
}
