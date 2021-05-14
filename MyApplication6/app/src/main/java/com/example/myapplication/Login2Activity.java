package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login2Activity extends AppCompatActivity {
private Button buttonCikisYap;
private TextView textViewCikti;
private SharedPreferences sp;
private SharedPreferences.Editor editor;
    private String editTextUsername;
    private String editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);

        buttonCikisYap = (Button) findViewById(R.id.buttonCikisYap);
        textViewCikti = (TextView) findViewById(R.id.textViewCikti);

        sp = getSharedPreferences("GirisBilgi", MODE_PRIVATE);
        editor = sp.edit();


        editTextUsername = sp.getString("username", "kullanıcı adı yok");
        editTextPassword = sp.getString("password", "şifre yok");

        textViewCikti.setText("Username"  + editTextUsername + "Password" + editTextPassword);


        buttonCikisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editor.remove("username");
                editor.remove("password");
                editor.commit();
                startActivity(new Intent(Login2Activity.this, LoginActivity.class));
                finish();
            }
        });
    }
}
