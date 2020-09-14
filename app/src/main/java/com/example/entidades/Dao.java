package com.example.entidades;

import java.util.List;
import java.util.ArrayList;

public class Dao {
    private static List<info_Veiculo> dados = new ArrayList<>();
    private static List<Abastecimento> abs = new ArrayList<>();

    public static void SalvarLitros(Abastecimento litro){
        abs.add(litro);
    };

    public static void Salvar(info_Veiculo carro){
        if(!dados.contains(carro)){
            dados.add(carro);
        }else{
            dados.remove(carro);
            dados.add(carro);
            dados.set(dados.indexOf(carro),
            carro
            );
        }
    };

    public static void Excluir(info_Veiculo carro){
        dados.remove(carro);
    };

    public static List getDados(){
        return dados;
    };
    public static List getAbs(){
        return abs;
    }
}
