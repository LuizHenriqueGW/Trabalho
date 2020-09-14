package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoDados extends SQLiteOpenHelper {

    public BancoDados(@Nullable Context context) {
        super(context, "Bancocarros", null, '1');
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CARROABAST(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + "NOME VARCHAR(50) NOT NULL, " + "PLACA VARCHAR(8) NOT NULL," + "COR VARCHAR(20) NOT NULL" + ")"
        );
    };

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
