package com.example.trabalho;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.db.BancoDados;
import com.example.entidades.Dao;
import com.example.entidades.DaoBanco;


public class MainActivity extends AppCompatActivity{
    private ListView listagem;
    private ListView listaview;
    private DaoBanco daodb;
    private BancoDados db;

    @Override
    protected void onCreate(Bundle SavedInstaceState){
        super.onCreate(SavedInstaceState);
        db = new BancoDados(this);
        daodb = new DaoBanco(db.getReadableDatabase());
        setContentView(R.layout.activity_main);
        listagem=findViewById(R.id.Listview);
        listaview=findViewById(R.id.abs_view);
        listagem.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, AbsActivity.class);
                intent.putExtra("a", position);
                startActivityForResult(intent, 5);
            }
        });
        atualizalistagem();
    }

    public void CliqueBotao(View view){
        Intent it = new Intent(MainActivity.this, Cadastro.class);
        startActivityForResult(it,952);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        atualizalistagem();
    }

    public void atualizalistagem(){
        ArrayAdapter adapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, daodb.getCarros());
        listagem.setAdapter(adapter);
        ArrayAdapter adapterlista = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item, Dao.getAbs());
        listaview.setAdapter(adapterlista);
    }

}