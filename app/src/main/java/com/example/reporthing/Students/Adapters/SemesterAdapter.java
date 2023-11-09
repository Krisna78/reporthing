package com.example.reporthing.Students.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.reporthing.R;
import com.example.reporthing.Students.Models.SemesterData;

import java.util.ArrayList;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterAdapter.holder> {
    Context context;
    ArrayList<SemesterData> arrayList = new ArrayList<>();
    public SemesterAdapter(Context context, ArrayList<SemesterData> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }
    @NonNull
    @Override
    public SemesterAdapter.holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_list_semester,parent,false);
        holder viewHolder = new holder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterAdapter.holder holder, int position) {
        holder.semesterName.setText("Semester "+arrayList.get(position).getSemesterKe());
        holder.thnAjaran.setText("Tahun Ajaran "+ arrayList.get(position).getThnAjaran());

        /*holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,);
                intent.putExtra("nisn",arrayList.get(position).getNisn());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public class holder extends RecyclerView.ViewHolder {
        TextView semesterName,thnAjaran;
        CardView cardView;
        public holder(@NonNull View itemView) {
            super(itemView);
            semesterName = itemView.findViewById(R.id.idSemester);
            thnAjaran = itemView.findViewById(R.id.thn_ajaran);
            cardView = itemView.findViewById(R.id.cardSemester);
        }
    }
}
