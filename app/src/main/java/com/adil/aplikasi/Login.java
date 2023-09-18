package com.adil.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

public class Login extends AppCompatActivity {

    private EditText etUsername,etPassword;
    private Button btnRegister1,btnLogin;
    private DatabaseReference database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=findViewById(R.id.btnLogin);
        btnRegister1=findViewById(R.id.btnRegister1);
        etUsername=findViewById(R.id.etUsername);
        etPassword=findViewById(R.id.etPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent home=new Intent(getApplicationContext(),Home.class);
               startActivity(home);
            }
        });


        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register= new Intent(getApplicationContext(),Register.class);
                startActivity(register);
            }

        });
    }
}