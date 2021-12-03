package com.example.bejostorelogin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class mainmenu extends AppCompatActivity {

    private Button logout, info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        logout = findViewById(R.id.button_logout);
        logout.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            startActivity(new Intent(mainmenu.this,loginpage.class));
            finish();
        });
        info = findViewById(R.id.btn_info);
        info.setOnClickListener(v -> {
            startActivity(new Intent(mainmenu.this,InfoActivity.class));
        });
    }
}