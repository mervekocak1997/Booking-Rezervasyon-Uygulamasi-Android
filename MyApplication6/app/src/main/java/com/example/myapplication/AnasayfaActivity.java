package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AnasayfaActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
private Toolbar toolbar2;
private RecyclerView rv;
private FloatingActionButton fab;
private ArrayList<Mulkler> mulklerArrayList;
private MulklerAdapter adapter;
Veritabani vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anasayfa);

        toolbar2 = findViewById(R.id.toolbar2);
        rv = findViewById(R.id.rv);
        fab = findViewById(R.id.fab);


        vt = new Veritabani(this);


        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        toolbar2.setTitle("ANA EKRAN");
        setSupportActionBar(toolbar2);


/*
        mulklerArrayList = new ArrayList<>();

        Mulkler m1 = new Mulkler( 1 , "Ev",  "General Şükrü Kanatlı Mah.,Kunduracı Abbuş Sok., DSİ Lojmanı 10/1 Antakya/Hatay", "1500TL(Aylık)", "4 +1 ", "Kombi", "2","200");
        Mulkler m2 = new Mulkler( 2 , "Ev", "Deniz Mah.,Uğur Mumcu Sok., DSİ Lojmanı No:91 Samandağ/Hatay", "900TL(Aylık)", "2 +1 ", "Kombi", "1","80");
        Mulkler m3 = new Mulkler( 3 , "Ev",  "Esentepe Mah., Cemal Süreya Sok.,  9/1 Selçuklu/Konya", "1100TL(Aylık)", "3 +1 ", "Doğalgaz", "9","160");
        Mulkler m4 = new Mulkler( 4 , "Ev",  "Akademi Mah., Esenler Sok., 3/1 Antakya/Hatay", "750TL(Aylık)", "1 +1 ", "Kombi", "3" , "100");
        Mulkler m5 = new Mulkler( 5 , "Ev", "Ataköy Mah.,Değirmenci Sok., Ataköy/İstanbul", "1800TL(Aylık)", "1 +1 ", "Kombi", "2", "160");


        mulklerArrayList.add(m1);
        mulklerArrayList.add(m2);
        mulklerArrayList.add(m3);
        mulklerArrayList.add(m4);
        mulklerArrayList.add(m5); */

mulklerArrayList = new MulklerDao().tumMulkler(vt);



adapter = new MulklerAdapter(AnasayfaActivity.this,mulklerArrayList,vt);
rv.setAdapter(adapter);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
alertGoster();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);

        MenuItem menuItem = menu.findItem(R.id.action_ara);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(this);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        Log.e("onQueryTextSubmit", query);

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.e("onQueryTextChange", newText);

      // mulklerArrayList = new MulklerDao().mulkAra(vt,newText);
       // adapter = new MulklerAdapter(this, mulklerArrayList);
       // rv.setAdapter(adapter);
        return false;
    }

    public void alertGoster(){
        LayoutInflater layout = LayoutInflater.from(this);
        View tasarim = layout.inflate(R.layout.alert_tasarim, null);

        final EditText editTextAd = tasarim.findViewById(R.id.editTextAd);
        final EditText editTextTip = tasarim.findViewById(R.id.editTextTip);
        final EditText editTextAdres = tasarim.findViewById(R.id.editTextAdres);
       final EditText editTextUcret = tasarim.findViewById(R.id.editTextUcret);
       final EditText editTextOda = tasarim.findViewById(R.id.editTextOda);
        final EditText editTextİsitma = tasarim.findViewById(R.id.editTextİsitma);
        final EditText editTextKat = tasarim.findViewById(R.id.editTextKat);
        final EditText editTextAidat = tasarim.findViewById(R.id.editTextAidat);

        AlertDialog.Builder ad = new AlertDialog.Builder(this);
        ad.setTitle("Mülk Ekle");
        ad.setView(tasarim);
        ad.setPositiveButton("Ekle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String mulk_ad = editTextAd.getText().toString().trim();
                String mulk_tip = editTextTip.getText().toString().trim();
                String mulk_adres = editTextAdres.getText().toString().trim();
                String mulk_ucret = editTextUcret.getText().toString().trim();
                String mulk_oda = editTextOda.getText().toString().trim();
                String mulk_isitma = editTextİsitma.getText().toString().trim();
                String mulk_kat = editTextKat.getText().toString().trim();
                String mulk_aidat = editTextAidat.getText().toString().trim();

                //aldığım veriy tekrardan çekmek isteseydim
               // mulklerArrayList = new MulklerDao().tumMulkler(vt);
               // adapter = new MulklerAdapter(AnasayfaActivity.this, mulklerArrayList);
               //rv.setAdapter(adapter);

                new  MulklerDao().mulkEkle(vt,mulk_ad,mulk_tip,mulk_adres,mulk_ucret,mulk_oda,mulk_kat,mulk_aidat,mulk_isitma);

                mulklerArrayList = new  MulklerDao().tumMulkler(vt);
                adapter = new MulklerAdapter(AnasayfaActivity.this,mulklerArrayList,vt);
                rv.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), mulk_ad+ "-" + mulk_tip+ "-"+mulk_adres+"-"+mulk_ucret+"-"+mulk_oda+"-"+mulk_isitma+"-"+mulk_kat+"-"+mulk_aidat, Toast.LENGTH_SHORT).show();
            }
        });

        ad.setNegativeButton("İptal", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        ad.create().show();


    }
}
