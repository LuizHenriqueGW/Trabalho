package com.example.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BancoABS extends SQLiteOpenHelper {

    public BancoABS (@Nullable Context context) {
        super(context, "BancoABS", null, '1');
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE ABAST(" + "ID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," + "LITROS INTEGER NOT NULL " + ")"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
