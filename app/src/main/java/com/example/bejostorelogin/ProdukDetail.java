package com.example.bejostorelogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProdukDetail extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_produk);

        Picasso.with(this)
                .load(getIntent().getIntExtra("image",0))
                .into(((ImageView)findViewById(R.id.image_product_main)));

        ((TextView) findViewById(R.id.product_name)).setText(getIntent().getStringExtra("name"));
        ((TextView) findViewById(R.id.product_price)).setText("Rp. " + getIntent().getIntExtra("price", 0));

        findViewById(R.id.button_primary).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProdukDetail.this, ProdukOrder.class);
                intent.putExtra("image", getIntent().getIntExtra("image",0));
                intent.putExtra("name", getIntent().getStringExtra("name"));
                intent.putExtra("price", getIntent().getIntExtra("price", 0));
                intent.putExtra("qty", getIntent().getIntExtra("qty", 0));
                startActivity(intent);
            }
        });



    }
}
