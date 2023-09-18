package com.adil.aplikasi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    private EditText etUsername,etEmail,etPassword;
    private Button btnRegister1;
    private DatabaseReference database ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etUsername= findViewById(R.id.etUsername);
        etEmail=findViewById(R.id.etPassword);
        etPassword=findViewById(R.id.etPassword);
        btnRegister1=findViewById(R.id.btnRegister1);
        database = FirebaseDatabase.getInstance().getReferenceFromUrl("https://aplikasi-31b0d-default-rtdb.firebaseio.com/");

        btnRegister1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=etUsername.getText().toString();
                String email=etEmail.getText().toString();
                String password=etPassword.getText().toString();

                if (username.isEmpty()||email.isEmpty()||password.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Silahkan Lengkapi data",Toast.LENGTH_SHORT).show();
                }else{
                    database=FirebaseDatabase.getInstance().getReference("users");
                    database.child(username).child("username").setValue(username);
                    database.child(username).child("email").setValue(email);
                    database.child(username).child("password").setValue(password);

                    Toast.makeText(getApplicationContext(),"Register Berhasil!",Toast.LENGTH_SHORT).show();
                    Intent Register= new Intent(getApplicationContext(),Login.class);
                    startActivity(Register);


                }

            }
        });
    }
}