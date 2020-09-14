package com.example.trabalho;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.db.BancoDados;
import com.example.entidades.Abastecimento;
import com.example.entidades.DaoBanco;
import com.example.entidades.info_Veiculo;

public class AbsActivity extends AppCompatActivity {
    private EditText n;
    private EditText p;
    private EditText c;
    private TextView Lt;
    private EditText qnt;
    private BancoDados db;
    private DaoBanco daobanco;

    @Override
    protected void onCreate(Bundle SavedInstaceState) {
        super.onCreate(SavedInstaceState);
        db=new BancoDados(this);
        daobanco=new DaoBanco(db.getWritableDatabase());
        setContentView(R.layout.activity_abastecimento);
        n=findViewById(R.id.ed_Nome);
        p=findViewById(R.id.ed_Placa);
        c=findViewById(R.id.ed_Cor);
        Lt=findViewById(R.id.textView6);
        Lt.setText(Abastecimento.getLitros());
        qnt=findViewById(R.id.Adc_abs);
    }
    public void Cliquedobotao_adc(View view){
        Abastecimento abastecimento = new Abastecimento();
        daobanco.adcAbs(abastecimento);
    }
    public void Cliquedobotao_rmv(View view){
        Abastecimento abastecimento = new Abastecimento();
        daobanco.dltAbs(abastecimento);
    }
    public void Cliquedobotao_dlt(View view){
        info_Veiculo carro = new info_Veiculo();
        daobanco.deletarCarro(carro.getID());
    }
    public void BotaoEditar(View view){
        info_Veiculo carro = new info_Veiculo();
        carro.setNome(n.getText().toString());
        carro.setPlaca(p.getText().toString());
        carro.setCor(c.getText().toString());
        daobanco.atualizarCarro(carro);
        super.onBackPressed();
    }
}
