package com.example.reporthing.Students.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;
import com.example.reporthing.Students.JadwalDetailsActivity;
import com.example.reporthing.Students.Models.jadwals.JadwalData;

import java.util.ArrayList;

public class JadwalAdapter extends RecyclerView.Adapter<JadwalAdapter.holder> {
    Context context;
    ArrayList<JadwalData> arrayList = new ArrayList<>();
    public JadwalAdapter(Context context,ArrayList<JadwalData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public JadwalAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_jadwal,parent,false);
        holder viewHolder = new holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalAdapter.holder holder, @SuppressLint("RecyclerView") int position) {
        holder.namaHari.setText(arrayList.get(position).getHari());
        holder.cardJadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JadwalDetailsActivity.class);
                intent.putExtra("hari",arrayList.get(position).getHari());
                intent.putExtra("nama_kelas",arrayList.get(position).getNamaKelas());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class holder extends RecyclerView.ViewHolder {
        TextView namaHari;
        CardView cardJadwal;
        public holder(@NonNull View itemView) {
            super(itemView);
            cardJadwal = itemView.findViewById(R.id.card_jadwal);
            namaHari = itemView.findViewById(R.id.idHari);
        }
    }
}
