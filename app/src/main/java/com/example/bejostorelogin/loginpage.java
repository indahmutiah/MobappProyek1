package com.example.bejostorelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class loginpage extends AppCompatActivity {

    private EditText LoginUsername, LoginPassword;
    private Button LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);

        LoginUsername = findViewById(R.id.LoginUsername);
        LoginPassword = findViewById(R.id.LoginPassword);
        LoginButton = findViewById(R.id.LoginButton);

        LoginButton.setOnClickListener(v -> {
            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
            databaseReference.child("registereduser").addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    String input1 = LoginUsername.getText().toString();
                    String input2 = LoginPassword.getText().toString();

                    if (snapshot.child(input1).exists() ) {
                        if (snapshot.child(input2).exists()) {
                            //setContentView(R.layout.activity_mainmenu);
                            startActivity(new Intent(loginpage.this,mainmenu.class));

                        } else {
                            Toast.makeText(loginpage.this, "Kata Sandi Salah", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(loginpage.this, "Data belum terdaftar", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });

        });


    }
}