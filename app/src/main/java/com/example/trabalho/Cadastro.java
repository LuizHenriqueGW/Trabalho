package com.example.trabalho;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.db.BancoABS;
import com.example.db.BancoDados;
import com.example.entidades.Abastecimento;
import com.example.entidades.Dao;
import com.example.entidades.DaoBanco;
import com.example.entidades.info_Veiculo;

public class Cadastro extends AppCompatActivity{
    private EditText n;
    private EditText p;
    private EditText c;
    private BancoDados db;
    private DaoBanco daobanco;

    @Override
    protected void onCreate(Bundle SavedInstaceState){
        super.onCreate(SavedInstaceState);
        db=new BancoDados(this);
        daobanco=new DaoBanco(db.getWritableDatabase());
        setContentView(R.layout.activity_cadastro);
        n=findViewById(R.id.cp_Nome);
        p=findViewById(R.id.cp_Placa);
        c=findViewById(R.id.cp_Cor);
    }

    public void BotaoSalvar(View view){
        info_Veiculo carro = new info_Veiculo();
        Abastecimento abast = new Abastecimento();
        carro.setNome(n.getText().toString());
        carro.setPlaca(p.getText().toString());
        carro.setCor(c.getText().toString());
        daobanco.inserirCarro(carro);
        daobanco.salvarAbs(abast);
        super.onBackPressed();
    }
}