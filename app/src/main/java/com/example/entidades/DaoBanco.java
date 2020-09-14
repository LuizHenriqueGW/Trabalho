package com.example.entidades;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.LinkedList;
import java.util.List;

public class DaoBanco {
    private SQLiteDatabase conexao;

    public DaoBanco(SQLiteDatabase conexao) {
        this.conexao = conexao;
    }

    public void inserirCarro(info_Veiculo carro){
        ContentValues values = new ContentValues();
        values.put("NOME",carro.getNome());
        values.put("PLACA",carro.getPlaca());
        values.put("COR",carro.getCor());
        conexao.insert("CARROABAST",null,values);
    }
    public void atualizarCarro(info_Veiculo carro){
        ContentValues values = new ContentValues();
        values.put("NOME",carro.getNome());
        values.put("PLACA",carro.getPlaca());
        values.put("COR",carro.getCor());
        conexao.update("CARROABAST",values, "ID=?", new String[]{
                carro.getID().toString()});
    }
    public void deletarCarro(Integer ID){
        conexao.delete("CARROABAST", "ID=?", new String[]{ID.toString()});
    }
    public List<info_Veiculo> getCarros(){
        List<info_Veiculo>carros = new LinkedList<>();
        Cursor cursor;
        info_Veiculo carro;
        cursor = conexao.rawQuery("SELECT * FROM CARROABAST", null);
        cursor.moveToFirst();
        for(int i=0; i<cursor.getCount();i++){
            carro = new info_Veiculo();
            carro.setID(cursor.getInt(cursor.getColumnIndex("ID")));
            carro.setNome(cursor.getString(cursor.getColumnIndex("ID")));
            carro.setPlaca(cursor.getString(cursor.getColumnIndex("ID")));
            carro.setCor(cursor.getString(cursor.getColumnIndex("ID")));
            carros.add(carro);
            cursor.moveToNext();
        }
        return carros;
    }
    public void salvarAbs(Abastecimento abs){
        ContentValues values = new ContentValues();
        values.put("LITROS",abs.getLitros());
        conexao.insert("ABAST",null,values);
    }
    public void adcAbs(Abastecimento abs){
        ContentValues values = new ContentValues();
        Integer a;
        values.put("LITROS",abs.getLitros());
        a= values.getAsInteger("LITROS");
        a = a+abs.getLitros();
        values.put("LITROS",a);
        conexao.update("ABAST",values, "ID=?",new String[]{abs.getID().toString()});
    }
    public void dltAbs(Abastecimento abs){
        ContentValues values = new ContentValues();
        values.put("LITROS", -abs.getLitros());
        conexao.update("ABAST",values,"ID=?", new String[]{abs.getID().toString()});
    }
}
