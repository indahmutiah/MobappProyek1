package com.example.bejostorelogin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PrediksiMain extends AppCompatActivity {
    private Button btn_pendapatan,btn_prediksi, back;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prediksi_main);
        btn_pendapatan = findViewById(R.id.btn_pendapatan_hari_ini);
        btn_prediksi = findViewById(R.id.btn_prediksi_pendapatan);
        back = findViewById(R.id.btn_kembali);

        btn_pendapatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PrediksiMain.this,PendapatanActivity.class));
            }
        });

        btn_prediksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrediksiMain.this,PrediksiActivity.class));
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PrediksiMain.this,mainmenu.class));
            }
        });


    }
}
