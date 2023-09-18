package com.adil.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    private Button btnSetor,btnSaldo,btnJenis,btnKeluar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnSetor=findViewById(R.id.btnSetor);
        btnSaldo=findViewById(R.id.btnSaldo);
        btnJenis=findViewById(R.id.btnJenis);
        btnKeluar=findViewById(R.id.btnKeluar);

        btnKeluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(getApplicationContext(),Login.class);
                startActivity(login);
            }
        });


        btnJenis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent jenissampah=new Intent(getApplicationContext(),JenisSampah.class);
                startActivity(jenissampah);
            }
        });

        btnSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent saldo= new Intent(getApplicationContext(), Saldo.class);
                startActivity(saldo);
            }
        });

        btnSetor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent setor=new Intent(getApplicationContext(),Setor.class);
                startActivity(setor);
            }

        });


    }
}