package com.example.bejostorelogin;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ProdukListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_produk);

        init();
    }

    private void init(){
        findViewById(R.id.img_akun).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProdukListActivity.this, Akun.class));

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setHasFixedSize(true);

        AdapterProduct adapterProduct = new AdapterProduct(Data.getListProduct());

        recyclerView.setAdapter(adapterProduct);
    }

    class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ProductViewHolder>{

        private List<produk> produkList;
        public AdapterProduct(List<produk>produkList){
            this.produkList = produkList;
        }
        public AdapterProduct() {
        }

        @NonNull
        @Override
        public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View view = inflater.inflate(R.layout.item_produk, parent, false);
            return new ProductViewHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull final ProductViewHolder holder, @SuppressLint("RecyclerView") final int position) {

            Picasso.with(holder.itemView.getContext())
                    .load(produkList.get(position).getImages())
                    .resize(150, 150)
                    .into(holder.image_product);

            holder.tv_name.setText(produkList.get(position).getName());
            holder.tv_price.setText("Rp. "+produkList.get(position).getPrice());
            holder.image_product.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(holder.itemView.getContext(), ProdukDetail.class);
                    intent.putExtra("image", produkList.get(position).getImages());
                    intent.putExtra("name", produkList.get(position).getName());
                    intent.putExtra("price", produkList.get(position).getPrice());
                    intent.putExtra("qty", produkList.get(position).getQty());

                    startActivity(intent) ;
                }
            });
        }

        @Override
        public int getItemCount() {
            return produkList.size();
        }

        class ProductViewHolder extends RecyclerView.ViewHolder{

            private ImageView image_product;
            private TextView tv_name;
            private TextView tv_price;

            public ProductViewHolder (@NonNull View itemView){
                super(itemView);
                image_product = itemView.findViewById(R.id.image_product);
                tv_name = itemView.findViewById(R.id.tv_name);
                tv_price = itemView.findViewById(R.id.tv_price);
            }
        }
    }
}