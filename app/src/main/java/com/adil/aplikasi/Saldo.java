package com.adil.aplikasi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Saldo extends AppCompatActivity {

    private TextView tvTotalSaldo;
    private EditText etJumlahPenarikan;
    private Button btnKembali, btnTarikSaldo;
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saldo);

        tvTotalSaldo = findViewById(R.id.tvTotalSaldo);
        etJumlahPenarikan = findViewById(R.id.etJumlahPenarikan);
        btnKembali = findViewById(R.id.btnKembali);
        btnTarikSaldo = findViewById(R.id.btnTarikSaldo);

        // Mengambil saldo dari Intent
        double saldo = getIntent().getDoubleExtra("saldo_key", 0.0);

        // Menampilkan saldo di TextView
        tvTotalSaldo.setText("Saldo Anda: " + saldo);

        // Inisialisasi referensi database
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aplikasi-31b0d-default-rtdb.firebaseio.com/");

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(getApplicationContext(), Home.class);
                startActivity(home);
            }
        });

        btnTarikSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tarikSaldo(saldo);
            }
        });
    }

    private void tarikSaldo(double saldo) {
        String jumlahPenarikanStr = etJumlahPenarikan.getText().toString().trim();

        if (!jumlahPenarikanStr.isEmpty()) {
            double jumlahPenarikan = Double.parseDouble(jumlahPenarikanStr);

            if (saldo >= jumlahPenarikan) {
                double saldoBaru = saldo - jumlahPenarikan;

                // Simpan saldo baru ke Firebase
                DatabaseReference saldoRef = database.child("total_saldo");
                saldoRef.setValue(saldoBaru);

                // Tampilkan saldo baru di TextView
                tvTotalSaldo.setText("Saldo Anda: " + saldoBaru);

                Toast.makeText(getApplicationContext(), "Penarikan berhasil", Toast.LENGTH_SHORT).show();
                etJumlahPenarikan.setText("");
            } else {
                Toast.makeText(getApplicationContext(), "Saldo tidak mencukupi", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Masukkan jumlah penarikan", Toast.LENGTH_SHORT).show();
        }
    }
}
