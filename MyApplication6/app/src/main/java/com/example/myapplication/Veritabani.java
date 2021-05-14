package com.example.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Veritabani extends SQLiteOpenHelper {
    public Veritabani(Context context) {
        super(context, "rehber.sqlite", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("CREATE TABLE  mulkler (mulk_id INTEGER PRIMARY KEY AUTOINCREMENT, mulk_ad TEXT, mulk_tip TEXT," +
        "mulk_adres TEXT,mulk_ucret TEXT,mulk_oda TEXT,mulk_isitma TEXT,mulk_kat TEXT,mulk_aidat TEXT);");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
sqLiteDatabase.execSQL("DROP TABLE IF EXISTS mulkler");
onCreate(sqLiteDatabase);
    }
}
