package com.example.bejostorelogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StockAdapter extends RecyclerView.Adapter<StockAdapter.MyViewHolder> {
    List<String> titles;
    List<Integer> images;
    Context context;
    LayoutInflater inflater;

    public StockAdapter(Context ctx, List <String> titles, List<Integer>images){
        this.titles = titles;
        this.images = images;
        this.inflater = LayoutInflater.from(ctx);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.single_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
        holder.icon.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView title;
        ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.listProduct);
            icon = itemView.findViewById(R.id.imgStock);
        }
    }

}
