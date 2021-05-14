package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class MulklerDao {
    public ArrayList<Mulkler> tumMulkler(Veritabani vt){
        ArrayList<Mulkler> mulklerArrayList =  new ArrayList<>();
        SQLiteDatabase db  = vt.getWritableDatabase();
        Cursor c  = db.rawQuery("SELECT * FROM mulkler", null);
        while (c.moveToNext()){
            Mulkler m = new Mulkler(c.getInt(c.getColumnIndex("mulk_id")), c.getString(c.getColumnIndex("mulk_ad")), c.getString(c.getColumnIndex("mulk_tip")), c.getString(c.getColumnIndex("mulk_adres")), c.getString(c.getColumnIndex("mulk_ucret")), c.getString(c.getColumnIndex("mulk_oda")), c.getString(c.getColumnIndex("mulk_isitma")), c.getString(c.getColumnIndex("mulk_kat")), c.getString(c.getColumnIndex("mulk_aidat")));
            mulklerArrayList.add(m);
        }
        db.close();
        return mulklerArrayList;
    }
    public ArrayList<Mulkler> tumMulkler(Veritabani vt,String aramaKelime){
        ArrayList<Mulkler> mulklerArrayList =  new ArrayList<>();
        SQLiteDatabase db  = vt.getWritableDatabase();
        Cursor c  = db.rawQuery("SELECT * FROM mulkler WHERE mulk_ad like '%"+ aramaKelime + "%'", null);
        while (c.moveToNext()){
            Mulkler m = new Mulkler(c.getInt(c.getColumnIndex("mulk_id")), c.getString(c.getColumnIndex("mulk_ad")), c.getString(c.getColumnIndex("mulk_tip")), c.getString(c.getColumnIndex("mulk_adres")), c.getString(c.getColumnIndex("mulk_ucret")), c.getString(c.getColumnIndex("mulk_oda")), c.getString(c.getColumnIndex("mulk_isitma")), c.getString(c.getColumnIndex("mulk_kat")), c.getString(c.getColumnIndex("mulk_aidat")));
            mulklerArrayList.add(m);
        }
        db.close();
        return mulklerArrayList;
    }
    public void mulkSil(Veritabani vt, int mulk_id){
        SQLiteDatabase db  = vt.getWritableDatabase();
        db.delete("mulkler", "mulk_id=?",new String[]{String.valueOf(mulk_id)});
        db.close();
    }
    public void mulkEkle(Veritabani vt, String  mulk_ad, String mulk_tip, String mulk_adres, String mulk_ucret, String mulk_oda, String mulk_kat, String mulk_aidat, String mulk_isitma){
        SQLiteDatabase db  = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mulk_ad",mulk_ad);
        values.put("mulk_tip",mulk_tip);
        values.put("mulk_adres",mulk_adres);
        values.put("mulk_ucret",mulk_ucret);
        values.put("mulk_oda",mulk_oda);
        values.put("mulk_isitma",mulk_isitma);
        values.put("mulk_kat",mulk_kat);
        values.put("mulk_aidat",mulk_aidat);

        db.insertOrThrow("mulkler", null, values);
        db.close();

    }
    public void mulkGuncelle(Veritabani vt,int mulk_id ,String  mulk_ad, String mulk_tip, String mulk_adres, String mulk_ucret, String mulk_oda, String mulk_kat, String mulk_aidat, String mulk_isitma){
        SQLiteDatabase db  = vt.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("mulk_ad",mulk_ad);
        values.put("mulk_tip",mulk_tip);
        values.put("mulk_adres",mulk_adres);
        values.put("mulk_ucret",mulk_ucret);
        values.put("mulk_oda",mulk_oda);
        values.put("mulk_isitma",mulk_isitma);
        values.put("mulk_kat",mulk_kat);
        values.put("mulk_aidat",mulk_aidat);

        db.update("mulkler", values,"mulk_id=?",new String[]{String.valueOf(mulk_id)});
        db.close();

    }
}
