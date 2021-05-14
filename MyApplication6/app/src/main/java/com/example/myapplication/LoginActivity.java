package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
private EditText editTextUsername, editTextMail, editTextPassword, editTextSifreTekrar, editTextTel;
private Button buttonGiris;
private SharedPreferences sp;
private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        editTextUsername = (EditText) findViewById(R.id.editTextUsername);
        editTextMail = (EditText) findViewById(R.id.editTextMail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextSifreTekrar = (EditText) findViewById(R.id.editTextSifreTekrar);
        editTextTel = (EditText) findViewById(R.id.editTextTel);
        buttonGiris = (Button) findViewById(R.id.buttonGiris);

        sp = getSharedPreferences("GirisBilgi" , MODE_PRIVATE);
        editor = sp.edit();


        buttonGiris.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editTextUsername.getText().toString().equals("merve") && editTextPassword.getText().toString().equals("123")){
                    editor.putString("username", editTextUsername.getText().toString());
                    editor.putString("password", editTextPassword.getText().toString());
                    editor.commit();

                    startActivity(new Intent(LoginActivity.this, Login2Activity.class));
                    finish();

                } else {
                    //startActivity(new Intent(MainActivity.this, ProfilEkraniActivity.class));
                    startActivity(new Intent(LoginActivity.this, AnasayfaActivity.class));
                    //Toast.makeText(getApplicationContext(), "Giriş hatalı", Toast.LENGTH_SHORT).show();
                }
            }
        });



        }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(LoginActivity.this,MainActivity.class));
    }
}
