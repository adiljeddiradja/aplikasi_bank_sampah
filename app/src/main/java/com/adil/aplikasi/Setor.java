package com.adil.aplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Setor extends AppCompatActivity {

    private DatabaseReference database;
    private EditText etWeight;
    private Button btnSetorKardus, btnSetorPlastik, btnSetorPlastikKeras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setor);

        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aplikasi-31b0d-default-rtdb.firebaseio.com/");

        etWeight = findViewById(R.id.etWeight);
        btnSetorKardus = findViewById(R.id.btnSetorKardus);
        btnSetorPlastik = findViewById(R.id.btnSetorPlastik);
        btnSetorPlastikKeras = findViewById(R.id.btnSetorPlastikKeras);

        btnSetorKardus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setorSampah("kardus");
            }
        });

        btnSetorPlastik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setorSampah("plastik");
            }
        });

        btnSetorPlastikKeras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setorSampah("plastik_keras");
            }
        });
    }

    private void setorSampah(String jenisSampah) {
        double weight = Double.parseDouble(etWeight.getText().toString());
        double saldo = weight * 1000;

        // Menyimpan data ke Firebase
        database.child("setoran").push().setValue(new Setoran(jenisSampah, weight, saldo));

        // Membuat Intent dan mengirim saldo ke SaldoActivity
        Intent intent = new Intent(this, Saldo.class);
        intent.putExtra("saldo_key", saldo);
        startActivity(intent);

        // Mengosongkan input field
        etWeight.setText("");
    }
}
