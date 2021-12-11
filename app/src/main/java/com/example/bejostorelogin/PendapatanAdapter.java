package com.example.bejostorelogin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PendapatanAdapter extends RecyclerView.Adapter<PendapatanAdapter.ViewHolder> {
    private List<String> tanggal, linkaja, ovo, total;
    private LayoutInflater inflater;

    public PendapatanAdapter(List<String> tanggal, List<String> linkaja, List<String> ovo, List<String> total, Context context) {
        this.tanggal = tanggal;
        this.linkaja = linkaja;
        this.ovo = ovo;
        this.total = total;
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item_predict, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String tgl = tanggal.get(position);
        String pembayaran_linkaja = linkaja.get(position);
        String pembayaran_ovo = ovo.get(position);
        String totall = total.get(position);

        holder.tgl.setText(tgl);
        holder.linkajaa.setText(pembayaran_linkaja);
        holder.ovoo.setText(pembayaran_ovo);
        holder.totalan.setText(totall);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tgl, linkajaa, ovoo, totalan;
        public ViewHolder(View itemview) {
            super(itemview);
            tgl = itemView.findViewById(R.id.tV_tgl);
            linkajaa = itemView.findViewById(R.id.tV_linkaja);
            ovoo = itemView.findViewById(R.id.tV_ovo);
            totalan = itemView.findViewById(R.id.tV_total);
        }
    }
}
