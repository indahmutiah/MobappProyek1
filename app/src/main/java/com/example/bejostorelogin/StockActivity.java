package com.example.bejostorelogin;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class StockActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    List<String> titles;
    List<Integer> images;
    StockAdapter adapter;

    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        recyclerView=findViewById(R.id.recycleView);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Gery Sereal");
        titles.add("Good Day");
        titles.add("Yakult");
        titles.add("Scarlett Lotion");
        titles.add("Cheetos Stick");
        titles.add("Beng-Beng");
        titles.add("Marimas");
        titles.add("Kecap Bango");

        images.add(R.drawable.gery);
        images.add(R.drawable.good_day);
        images.add(R.drawable.yakult);
        images.add(R.drawable.scarlett);
        images.add(R.drawable.cheetos);
        images.add(R.drawable.beng_beng);
        images.add(R.drawable.marimas);
        images.add(R.drawable.kecap_bango);

        adapter = new StockAdapter(this,titles,images);
        layoutManager=new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);

    }
}
