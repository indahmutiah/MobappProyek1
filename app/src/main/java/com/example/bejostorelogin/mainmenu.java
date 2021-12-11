package com.example.bejostorelogin;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

public class mainmenu extends AppCompatActivity {

    private Button logout, info, stock,rekap, pembayaran;
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
        stock = findViewById(R.id.btn_stock);
        stock.setOnClickListener(v -> {
            startActivity(new Intent(mainmenu.this,StockActivity.class));
        });
        rekap=findViewById(R.id.btn_rekap);
        rekap.setOnClickListener(v -> {
            startActivity(new Intent(mainmenu.this, PrediksiMain.class));
        });
        pembayaran=findViewById(R.id.btn_byr);
        pembayaran.setOnClickListener(v -> {
            startActivity(new Intent(mainmenu.this,ProdukListActivity.class));
        });
    }
}