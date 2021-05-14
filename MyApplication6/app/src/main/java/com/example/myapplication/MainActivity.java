package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private TextView cikti;
    private Button buttonGit;
private Button buttonAnasayfayaGit;
private Button buttonLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cikti = (TextView) findViewById(R.id.cikti);
        buttonGit = (Button) findViewById(R.id.buttonGit);
        buttonAnasayfayaGit = (Button) findViewById(R.id.buttonAnasayfayaGit);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });




        buttonGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, ProfilActivity.class));
            }
        });


        buttonAnasayfayaGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AnasayfaActivity.class));
            }
        });

        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(getBaseContext());

        String ka = sp.getString("kullaniciAdi", "Veri yok");
        String ks = sp.getString("kullaniciSoyAdi", "Veri yok");
        String kks = sp.getString("kullaniciSifre", "Veri yok");
        boolean bildirim = sp.getBoolean("bildirim", false);
        boolean profilGuvenlik = sp.getBoolean("profilGuvenlik", false);
        String yedekleme = sp.getString("yedekleme", "1");

        cikti.setText("Kullanıcı Adı: " + ka+ "\n" + "Kullanıcı Soyadı:" + ks+ "\n"+ "Kullanıcı Şifre:"+ kks + "\n"  +"Bildirim İzni:" + bildirim + "\n" + "Profil Güvenlik:"+ profilGuvenlik + "\n" + "Yedekleme:" + yedekleme  );



    }
}
