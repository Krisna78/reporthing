package com.example.reporthing.Students.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;
import com.example.reporthing.Students.Models.JadwalDetails.JadwalDetailData;
import com.example.reporthing.Students.Models.jadwals.JadwalData;

import java.util.ArrayList;

public class JadwalDetailAdapter extends RecyclerView.Adapter<JadwalDetailAdapter.holder> {
    Context context;
    ArrayList<JadwalDetailData> arrayList = new ArrayList<>();

    public JadwalDetailAdapter(Context context, ArrayList<JadwalDetailData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public JadwalDetailAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_jadwal_details,parent,false);
        holder viewHolder = new holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalDetailAdapter.holder holder, int position) {
        holder.namaHari.setText(arrayList.get(position).getNamaMapel());
        holder.jam.setText(arrayList.get(position).getJamMulai() + " - "+arrayList.get(position).getJamSelesai());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class holder extends RecyclerView.ViewHolder {
        TextView namaHari,jam;
        public holder(@NonNull View itemView) {
            super(itemView);
            namaHari = itemView.findViewById(R.id.jadwalDetailHari);
            jam = itemView.findViewById(R.id.jamPelajaran);
        }
    }
}
